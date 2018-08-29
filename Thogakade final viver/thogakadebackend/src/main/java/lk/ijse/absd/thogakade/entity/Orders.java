package lk.ijse.absd.thogakade.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
@Entity
public class Orders{

    @Id
    private String orderId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderDetail>orderDetailList;


    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private double totalAmount;

    public Orders() {
    }

    public Orders(String orderId, List<OrderDetail> orderDetailList, Customer customer, double totalAmount) {
        this.orderId = orderId;
        this.orderDetailList = orderDetailList;
        this.customer = customer;
        this.totalAmount = totalAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId='" + orderId + '\'' +
                ", orderDetailList=" + orderDetailList +
                ", customer=" + customer +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
