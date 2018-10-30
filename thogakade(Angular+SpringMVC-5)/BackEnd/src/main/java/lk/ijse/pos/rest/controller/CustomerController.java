package lk.ijse.pos.rest.controller;


import lk.ijse.pos.rest.dto.CustomerDTO;
import lk.ijse.pos.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomer(@PathVariable("id") String customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCustomer(@PathVariable("id") String customerId){
        return customerService.deleteCustomer(customerId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody  CustomerDTO customerDTO){
        return customerService.saveCustomer(customerDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCustomersCount(){
        return customerService.getTotalCustomers();
    }


}
