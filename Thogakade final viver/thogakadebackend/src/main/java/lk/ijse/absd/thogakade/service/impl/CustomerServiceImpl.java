package lk.ijse.absd.thogakade.service.impl;

import lk.ijse.absd.thogakade.dto.CustomerDTO;
import lk.ijse.absd.thogakade.entity.Customer;
import lk.ijse.absd.thogakade.repository.CustomerRepository;
import lk.ijse.absd.thogakade.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandunDilhan on 8/21/2018.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveCustomer(CustomerDTO dto) {
        customerRepository.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateCustomer(String customerId, CustomerDTO dto) {
        if(!dto.getId().equals(customerId)){
            throw new RuntimeException("Customer ID mismatched");
        }
        if (customerRepository.existsById(customerId)){
            customerRepository.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
        }else{
            throw new RuntimeException("Customer doesn't exist");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerDTO findCustomer(String customerId) {
        Customer customer=customerRepository.findById(customerId).get();
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> allCustomers = customerRepository.findAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        for (Customer allGetCustoomer:allCustomers) {
            dtos.add(new CustomerDTO(allGetCustoomer.getId(),allGetCustoomer.getName(),allGetCustoomer.getAddress()));
        }
        return dtos;
    }
}
