/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.sql.Connection;
import lk.ijse.pos.business.custom.OrderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.model.OrderDTO;
import lk.ijse.pos.model.OrderDetailDTO;

/**
 *
 * @author niroth
 */
public class OrderBOImpl implements OrderBO{

    private OrderDAO orderDAOImpl;
    private OrderDetailDAO orderDetailDAO;
    private ItemDAO itemDAO;
    
    public OrderBOImpl(){
        this.itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        this.orderDetailDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER_DETAILS);
        this.orderDAOImpl = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    }

    public boolean addOrder(OrderDTO order) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {

            boolean result = orderDAOImpl.save(new Orders(order.getId(), order.getDate(), order.getCustomerId()));

            if (!result) {
                return false;
            }

            for (OrderDetailDTO orderDetailDTO : order.getItemDetailList()) {

                result = orderDetailDAO.save(new OrderDetail(orderDetailDTO.getOrderId(), orderDetailDTO.getItemCode(), orderDetailDTO.getQty(), orderDetailDTO.getUnitPrice()));

                if (!result) {
                    connection.rollback();
                    return false;
                }

                Item item = itemDAO.search(orderDetailDTO.getItemCode());
                int currentQty = item.getQtyOnHand();
                currentQty = currentQty - orderDetailDTO.getQty();
                item.setQtyOnHand(currentQty);

                result = itemDAO.update(item);

                if (!result) {
                    connection.rollback();
                    return false;
                }

            }

            connection.commit();
            return true;

        } finally {
            connection.setAutoCommit(true);
        }
    }
}
