/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.model.OrderDTO;

/**
 *
 * @author ranjith-suranga
 */
public class OrderDAOImpl implements OrderDAO{

    @Override
    public boolean save(Orders order) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Orders VALUES (?,?,?)", order.getId(), order.getDate(), order.getCustomerId())>0;
    }

    @Override
    public boolean update(Orders order) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Orders SET date=?, customerId=? WHERE id=?", order.getDate(), order.getCustomerId(), order.getId())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Orders search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Orders> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
