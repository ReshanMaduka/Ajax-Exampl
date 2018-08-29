package lk.ijse.absd.thogakade.service;

import lk.ijse.absd.thogakade.dto.CustomerDTO;

import java.util.List;

/**
 * Created by sandunDilhan on 8/21/2018.
 */
public interface CustomerService {

    void saveCustomer(CustomerDTO dto);

    void updateCustomer(String customerId, CustomerDTO dto);

    void deleteCustomer(String customerId);

    CustomerDTO findCustomer(String customerId);

    List<CustomerDTO> findAllCustomers();

}
