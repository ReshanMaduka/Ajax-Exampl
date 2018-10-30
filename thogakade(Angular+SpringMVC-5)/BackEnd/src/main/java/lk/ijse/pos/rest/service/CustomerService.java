package lk.ijse.pos.rest.service;


import lk.ijse.pos.rest.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {

    public ArrayList<CustomerDTO> getAllCustomers();

    public CustomerDTO getCustomer(String customerId);

    public boolean deleteCustomer(String customerId);

    public boolean saveCustomer(CustomerDTO customerDTO);

    public long getTotalCustomers();

}
