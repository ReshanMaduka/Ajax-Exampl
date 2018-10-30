package lk.ijse.pos.rest.service.impl;


import lk.ijse.pos.rest.entity.Customer;
import lk.ijse.pos.rest.repository.CustomerRepository;
import lk.ijse.pos.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import lk.ijse.pos.rest.dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer>customers=customerRepository.findAll();
        
        ArrayList<CustomerDTO>alCustomers=new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDTO customerDTO=new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

            alCustomers.add(customerDTO);
        }

        return alCustomers;
    }

    @Override
    public CustomerDTO getCustomer(String customerId) {

        Customer customer=customerRepository.findById(customerId).get();

        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
        return true;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveCustomer(CustomerDTO customerDTO) {
        Customer customer=new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress());
        customerRepository.save(customer);
        return true;
    }

    @Override
    public long getTotalCustomers() {
        return customerRepository.getTotalCustomers();
    }

}
