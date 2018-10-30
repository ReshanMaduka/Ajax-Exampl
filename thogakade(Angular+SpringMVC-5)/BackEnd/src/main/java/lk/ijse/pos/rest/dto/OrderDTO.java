package lk.ijse.pos.rest.dto;

import java.util.List;

public class OrderDTO {
    private String oid;
    private String orderDate;
    private CustomerDTO customerDTO;
    private List<OrderDetailDTO> orderDetailDTOs;

    public OrderDTO(String oid, String orderDate, CustomerDTO customerDTO, List<OrderDetailDTO> orderDetailDTOs) {
        this.setOid(oid);
        this.setOrderDate(orderDate);
        this.setCustomerDTO(customerDTO);
        this.setOrderDetailDTOs(orderDetailDTOs);
    }

    public OrderDTO() {

    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTOs() {
        return orderDetailDTOs;
    }

    public void setOrderDetailDTOs(List<OrderDetailDTO> orderDetailDTOs) {
        this.orderDetailDTOs = orderDetailDTOs;
    }
}
