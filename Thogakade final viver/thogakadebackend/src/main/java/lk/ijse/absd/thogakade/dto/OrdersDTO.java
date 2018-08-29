package lk.ijse.absd.thogakade.dto;

import lk.ijse.absd.thogakade.entity.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
public class OrdersDTO{

    private String orderId;

    private List<OrderDetailDTO>orderDetailDTOList;

    private CustomerDTO customerDTO;

    private double totalAmount;

    public OrdersDTO() {
    }

    public OrdersDTO(String orderId, List<OrderDetailDTO> orderDetailDTOList, CustomerDTO customerDTO, double totalAmount) {
        this.orderId = orderId;
        this.orderDetailDTOList = orderDetailDTOList;
        this.customerDTO = customerDTO;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderDetailDTO> getOrderDetailDTOList() {
        return orderDetailDTOList;
    }

    public void setOrderDetailDTOList(List<OrderDetailDTO> orderDetailDTOList) {
        this.orderDetailDTOList = orderDetailDTOList;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
