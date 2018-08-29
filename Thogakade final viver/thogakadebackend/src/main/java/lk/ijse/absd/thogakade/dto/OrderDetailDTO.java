package lk.ijse.absd.thogakade.dto;

import lk.ijse.absd.thogakade.entity.Item;
import lk.ijse.absd.thogakade.entity.OrderDetailPk;
import lk.ijse.absd.thogakade.entity.Orders;

/**
 * Created by sandunDilhan on 8/22/2018.
 */
public class OrderDetailDTO {
    private int qty;
    private double total;

    private ItemDTO itemDTO;


    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int qty, double total, ItemDTO itemDTO) {
        this.qty = qty;
        this.total = total;
        this.itemDTO = itemDTO;
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

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }
}
