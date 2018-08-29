package lk.ijse.absd.thogakade.service;

import lk.ijse.absd.thogakade.dto.OrderDetailDTO;
import lk.ijse.absd.thogakade.dto.OrdersDTO;

import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
public interface PlaceOrderService {
    void saveOrderDetail(OrdersDTO dto);

    void updateOrderDetail(String orderId , OrderDetailDTO dto);

    void deleteOrderDetail(String orderId);

//    OrdersDTO findOrder(String ItemCode);
//
//    List<OrdersDTO> findAllOrder();
}
