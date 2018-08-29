/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.pos.business.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.model.CustomerDTO;

/**
 *
 * @author niroth
 */
public class CustomerBOImpl implements CustomerBO{

    private CustomerDAO customerDAO;
    
    public CustomerBOImpl(){
        this.customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> customers = customerDAO.getAll();
        ArrayList<CustomerDTO> dtos = new ArrayList<>();
        for (Customer e : customers) {
            dtos.add(new CustomerDTO(e.getId(), e.getName(), e.getAddress(), e.getSalary()));
        }
        return dtos;
    }

    public ArrayList<String> getAllCustomerIds() throws Exception {
        ArrayList<Customer> allCustomers = customerDAO.getAll();
        ArrayList<String> customerIds = new ArrayList<>();
        for (Customer customer : allCustomers) {
            customerIds.add(customer.getId());
        }
        return customerIds;
    }

    public CustomerDTO searchCustomer(String id) throws Exception {
        Customer customer = customerDAO.search(id);
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary());
    }

    public boolean deleteCustomer(String id) throws Exception {
        return customerDAO.delete(id);
    }

    public boolean addCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.save(new Customer(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()));
    }

    public boolean updateCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.update(new Customer(customer.getId(), customer.getName(), customer.getAddress(), customer.getSalary()));
    }
}
