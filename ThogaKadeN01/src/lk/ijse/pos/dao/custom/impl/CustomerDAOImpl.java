/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.pos.dao.CrudUtil;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.model.CustomerDTO;

/**
 *
 * @author ranjith-suranga
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(Customer customer) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?)", customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()) > 0;
    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Customer SET name=?, address=?, salary=? WHERE id=? ", entity.getName(), entity.getAddress(), entity.getSalary(), entity.getId()) > 0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Customer where id=?", id) > 0;
    }

    @Override
    public Customer search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Customer where id=? ", id);
        if (rst.next()) {
            return new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"), rst.getDouble("salary"));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Customer> getAll() throws Exception {
        ArrayList<Customer> alCustomers = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()) {
            alCustomers.add(new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4)));
        }
        return alCustomers;
    }

}
