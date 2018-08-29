package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.OrderDetailDTO;
import lk.ijse.absd.thogakade.dto.OrdersDTO;
import lk.ijse.absd.thogakade.service.PlaceOrderService;
import lk.ijse.absd.thogakade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandunDilhan on 8/25/2018.
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public long getOrderCount(){
        return orderService.getOrderCount();
    }

}
