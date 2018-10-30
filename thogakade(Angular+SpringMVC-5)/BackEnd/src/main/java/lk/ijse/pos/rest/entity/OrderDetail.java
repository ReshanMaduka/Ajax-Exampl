package lk.ijse.pos.rest.entity;

import javax.persistence.*;

@Entity
public class OrderDetail {
    private int qty;
    private double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private Order order;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "iid",referencedColumnName = "id",insertable = false,updatable = false)
    private Item item;
    @EmbeddedId
    private OrderDetail_PK orderDetail_PK;

    public OrderDetail() {
    }

    public OrderDetail(int qty, double totalPrice, Order order, Item item, OrderDetail_PK orderDetail_PK) {
        this.setQty(qty);
        this.setTotalPrice(totalPrice);
        this.setOrder(order);
        this.setItem(item);
        this.setOrderDetail_PK(orderDetail_PK);
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public OrderDetail_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    public void setOrderDetail_PK(OrderDetail_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }
}
