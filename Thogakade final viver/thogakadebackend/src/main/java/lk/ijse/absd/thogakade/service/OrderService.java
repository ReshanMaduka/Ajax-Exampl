package lk.ijse.absd.thogakade.service;

import lk.ijse.absd.thogakade.dto.OrdersDTO;

import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
public interface OrderService {
    void saveOrder(OrdersDTO dto);

    void updateOrder(String orderId , OrdersDTO dto);

    void deleteOrder(String orderId);

    OrdersDTO findOrder(String ItemCode);

    List<OrdersDTO> findAllOrder();

    long getOrderCount();
}
