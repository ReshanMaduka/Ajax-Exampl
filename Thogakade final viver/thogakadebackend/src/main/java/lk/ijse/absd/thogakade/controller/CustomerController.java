package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.CustomerDTO;
import lk.ijse.absd.thogakade.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PutMapping
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "save customer";
    }

    @PostMapping("/{id}")
    public String updateCustomer(@PathVariable("id") String customerId, @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerId,customerDTO);
        return "update customer";
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") String customerId){
        customerService.deleteCustomer(customerId);
        return "delete customer";
    }

    @GetMapping("/{id}")
    public CustomerDTO findByCustomerId(@PathVariable("id") String customerId){
        return customerService.findCustomer(customerId);
    }

    @GetMapping
    public List<CustomerDTO>getAllCustomer(){
        return customerService.findAllCustomers();
    }
}
