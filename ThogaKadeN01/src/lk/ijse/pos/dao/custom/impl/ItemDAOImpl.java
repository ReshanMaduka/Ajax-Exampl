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
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.entity.Item;

/**
 *
 * @author ranjith-suranga
 */
public class ItemDAOImpl implements ItemDAO{

    @Override
    public boolean save(Item item) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)", item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand())>0;
    }

    @Override
    public boolean update(Item item) throws Exception {
        return CrudUtil.executeUpdate("UPDATE Item SET description=?, qtyOnHand=?, unitPrice=? WHERE code=?", item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(),item.getCode())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("DELETE From Item where code=?", id)>0;
    }

    @Override
    public Item search(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Item where code=? ", id);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getInt(4));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Item> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Item");
        ArrayList<Item> itemList = new ArrayList<>();
        while (rst.next()) {
            Item item = new Item(rst.getString("code"), rst.getString("description"), rst.getDouble("unitPrice"), rst.getInt("qtyOnHand"));
            itemList.add(item);
        }
        return itemList;
    }
    
}
