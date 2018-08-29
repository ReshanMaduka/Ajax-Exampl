/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.custom.impl;

import java.util.ArrayList;
import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.OrderDetail_PK;

/**
 *
 * @author ranjith-suranga
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{
    
    @Override
    public boolean save(OrderDetail orderDetail) throws Exception {
        return CrudUtil.executeUpdate("Insert into OrderDetail Values(?,?,?,?)", orderDetail.getOrderDetail_PK().getOrderId(),orderDetail.getOrderDetail_PK().getItemCode(), orderDetail.getQty(),orderDetail.getUnitPrice() ) > 0;
    }

    @Override
    public boolean update(OrderDetail entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(OrderDetail_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetail search(OrderDetail_PK id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrderDetail> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
