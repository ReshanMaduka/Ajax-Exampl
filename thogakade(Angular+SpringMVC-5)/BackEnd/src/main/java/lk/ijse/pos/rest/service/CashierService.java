package lk.ijse.pos.rest.service;

import lk.ijse.pos.rest.dto.CustomerDTO;
import lk.ijse.pos.rest.dto.OrderDTO;

public interface CashierService {

    public boolean saveOrder(OrderDTO orderDTO);

    public long getTotalOrders();

}
