/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.controller;

import java.util.ArrayList;
import lk.ijse.pos.business.custom.CustomerBO;
import lk.ijse.pos.business.custom.ItemBO;
import lk.ijse.pos.business.custom.OrderBO;
import lk.ijse.pos.business.custom.impl.CustomerBOImpl;
import lk.ijse.pos.business.custom.impl.ItemBOImpl;
import lk.ijse.pos.business.custom.impl.OrderBOImpl;
import lk.ijse.pos.model.CustomerDTO;
import lk.ijse.pos.model.ItemDTO;
import lk.ijse.pos.model.OrderDTO;

/**
 *
 * @author ranjith-suranga
 */
public class PlaceOrderController {

    private static CustomerBO customerBO = new CustomerBOImpl();
    private static ItemBO itemBO = new ItemBOImpl();
    private static OrderBO orderBO = new OrderBOImpl();

    public static ArrayList<String> getAllCustomerIds() throws Exception {
        return customerBO.getAllCustomerIds();
    }

    public static ArrayList<ItemDTO> getAllItems() throws Exception {
        return itemBO.getAllItems();
    }

    public static boolean saveOrder(OrderDTO order) throws Exception {
        return orderBO.addOrder(order);
    }

    public static CustomerDTO searchCustomer(String id) throws Exception {
        return customerBO.searchCustomer(id);
    }

    public static ItemDTO searchItem(String code) throws Exception {
        return itemBO.searchItem(code);
    }

}
