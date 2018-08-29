package lk.ijse.absd.thogakade.controller;

import lk.ijse.absd.thogakade.dto.OrderDetailDTO;
import lk.ijse.absd.thogakade.dto.OrdersDTO;
import lk.ijse.absd.thogakade.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sandunDilhan on 8/27/2018.
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/placeOrders")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @PutMapping
    public String savePlaceOrder(@RequestBody OrdersDTO ordersDTO){
        System.out.println(ordersDTO.getOrderDetailDTOList());
        placeOrderService.saveOrderDetail(ordersDTO);
        return "save success";
    }
}
