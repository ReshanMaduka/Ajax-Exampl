package lk.ijse.pos.rest.controller;

import lk.ijse.pos.rest.dto.OrderDTO;
import lk.ijse.pos.rest.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/orders")
public class CashierController {

    @Autowired
    private CashierService cashierService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody OrderDTO orderDTO){
        return cashierService.saveOrder(orderDTO);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getOrdersCount(){
        return cashierService.getTotalOrders();
    }

}
