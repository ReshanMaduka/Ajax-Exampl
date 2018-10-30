package lk.ijse.pos.rest.service.impl;


import lk.ijse.pos.rest.dto.ItemDTO;
import lk.ijse.pos.rest.dto.OrderDTO;
import lk.ijse.pos.rest.dto.OrderDetailDTO;
import lk.ijse.pos.rest.entity.*;
import lk.ijse.pos.rest.repository.OrderRepository;
import lk.ijse.pos.rest.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CashierServiceImpl implements CashierService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveOrder(OrderDTO orderDTO) {

        List<OrderDetailDTO> orderDetailDTOs = orderDTO.getOrderDetailDTOs();
        Customer customer=new Customer(orderDTO.getCustomerDTO().getId(),orderDTO.getCustomerDTO().getName(),orderDTO.getCustomerDTO().getAddress());

        Item item=null;
        List<OrderDetail> orderDetails = new ArrayList<>();

        Order order =new Order(orderDTO.getOid(),orderDTO.getOrderDate(),orderDetails,customer);

        for (OrderDetailDTO orderDetailDTO : orderDetailDTOs) {
            item=new Item();
            ItemDTO itemDTO = orderDetailDTO.getItemDTO();
            item.setId(itemDTO.getId());
            item.setQty(itemDTO.getQty());
            item.setDescription(itemDTO.getDescription());
            item.setPrice(itemDTO.getPrice());

            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setItem(item);
            orderDetail.setOrder(order);
            orderDetail.setQty(orderDetailDTO.getQty());
            orderDetail.setTotalPrice(orderDetailDTO.getTotalPrice());
            orderDetail.setOrderDetail_PK(new OrderDetail_PK(orderDTO.getOid(),itemDTO.getId()));

            orderDetails.add(orderDetail);
        }

        orderRepository.save(order);

        return true;
    }

    @Override
    public long getTotalOrders() {
        return orderRepository.getTotalOrders();
    }
}
