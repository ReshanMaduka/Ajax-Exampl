package lk.ijse.pos.rest.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`Orders`")
public class Order {
    @Id
    private String oid;
    private String orderDate;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Order(String oid, String orderDate, List<OrderDetail> orderDetails, Customer customer) {
        this.setOid(oid);
        this.setOrderDate(orderDate);
        this.setOrderDetails(orderDetails);
        this.setCustomer(customer);
    }

    public Order() {
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

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", orderDate='" + orderDate + '\'' +
                ", orderDetails=" + orderDetails +
                ", customer=" + customer +
                '}';
    }
}
