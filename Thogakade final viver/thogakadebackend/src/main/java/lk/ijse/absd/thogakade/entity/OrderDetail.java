package lk.ijse.absd.thogakade.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
@Entity
public class OrderDetail {

    private int qty;
    private double total;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false))
    private Orders order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns(@JoinColumn(name = "code",referencedColumnName = "code",insertable = false,updatable = false))
    private Item item;

    @EmbeddedId
    private OrderDetailPk orderDetailPK;

    public OrderDetail() {
    }

    public OrderDetail(int qty, double total, Orders order, Item item, OrderDetailPk orderDetailPK) {
        this.qty = qty;
        this.total = total;
        this.order = order;
        this.item = item;
        this.orderDetailPK = orderDetailPK;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderDetailPk getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPk orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "qty=" + qty +
                ", total=" + total +
                ", order=" + order +
                ", item=" + item +
                ", orderDetailPK=" + orderDetailPK +
                '}';
    }
}
