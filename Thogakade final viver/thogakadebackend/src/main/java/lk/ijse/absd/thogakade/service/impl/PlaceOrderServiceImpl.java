package lk.ijse.absd.thogakade.service.impl;

import jdk.nashorn.internal.objects.NativeArray;
import lk.ijse.absd.thogakade.dto.ItemDTO;
import lk.ijse.absd.thogakade.dto.OrderDetailDTO;
import lk.ijse.absd.thogakade.dto.OrdersDTO;
import lk.ijse.absd.thogakade.entity.*;
import lk.ijse.absd.thogakade.repository.OrdersDetailRepository;
import lk.ijse.absd.thogakade.repository.OrdersRepository;
import lk.ijse.absd.thogakade.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandunDilhan on 8/26/2018.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PlaceOrderServiceImpl implements PlaceOrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveOrderDetail(OrdersDTO orderDTO) {

        Orders order=new Orders();
        List<OrderDetail> orderDetailList=new ArrayList<>();
        Customer customer=new Customer(orderDTO.getCustomerDTO().getId(),orderDTO.getCustomerDTO().getName(),
                orderDTO.getCustomerDTO().getAddress());

        order.setOrderId(orderDTO.getOrderId());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setCustomer(customer);

        List<OrderDetailDTO> orderDetailDTOs = orderDTO.getOrderDetailDTOList();
        for (OrderDetailDTO detailDTO : orderDetailDTOs) {
            Item item=new Item(detailDTO.getItemDTO().getCode(),detailDTO.getItemDTO().getDescription(),
                    detailDTO.getItemDTO().getUnitPrice(),detailDTO.getItemDTO().getQtyOnHand());

            OrderDetail orderDetail=new OrderDetail(detailDTO.getQty(),detailDTO.getTotal(),
                    order,item,new OrderDetailPk(orderDTO.getOrderId(),item.getCode()));

            orderDetailList.add(orderDetail);
        }

        order.setOrderDetailList(orderDetailList);

        for (OrderDetail orderDetail : orderDetailList) {
            System.out.println(orderDetail.getQty());
        }

        ordersRepository.save(order);
    }

    @Override
    public void updateOrderDetail(String orderId, OrderDetailDTO dto) {

    }

    @Override
    public void deleteOrderDetail(String orderId) {

    }
}
