package lk.ijse.absd.thogakade.service.impl;

import lk.ijse.absd.thogakade.dto.OrdersDTO;
import lk.ijse.absd.thogakade.entity.Orders;
import lk.ijse.absd.thogakade.repository.OrdersRepository;
import lk.ijse.absd.thogakade.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveOrder(OrdersDTO dto) {

    }

    @Override
    public void updateOrder(String orderId, OrdersDTO dto) {

    }

    @Override
    public void deleteOrder(String orderId) {

    }

    @Override
    public OrdersDTO findOrder(String ItemCode) {
        return null;
    }

    @Override
    public List<OrdersDTO> findAllOrder() {
        return null;
    }

    @Override
    public long getOrderCount() {
        return ordersRepository.count();
    }
}
