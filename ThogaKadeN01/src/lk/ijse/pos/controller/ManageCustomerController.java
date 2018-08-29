/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.controller;

import java.util.ArrayList;
import lk.ijse.pos.business.custom.CustomerBO;
import lk.ijse.pos.business.custom.impl.CustomerBOImpl;
import lk.ijse.pos.model.CustomerDTO;

/**
 *
 * @author ranjith-suranga
 */
public class ManageCustomerController {
    
    private static  CustomerBO CustomerBO = new CustomerBOImpl();
    
    public static boolean saveCustomer(CustomerDTO customer) throws Exception{
        return CustomerBO.addCustomer(customer);
    }
    
    public static boolean updateCustomer(CustomerDTO customer) throws Exception{
        return CustomerBO.updateCustomer(customer);
    }
    
    public static boolean deleteCustomer(String customerID) throws Exception{
        return CustomerBO.deleteCustomer(customerID);
    }
    
    public static ArrayList<CustomerDTO> getAllCustomers()throws Exception{
        return CustomerBO.getAllCustomers();
    }
    
}
