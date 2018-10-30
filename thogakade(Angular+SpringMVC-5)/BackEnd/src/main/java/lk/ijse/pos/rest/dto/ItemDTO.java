package lk.ijse.pos.rest.dto;

public class ItemDTO {

    private String id;
    private String description;
    private int qty;
    private double price;

    public ItemDTO(String id, String description, int qty, double price) {
        this.setId(id);
        this.setDescription(description);
        this.setQty(qty);
        this.setPrice(price);
    }

    public ItemDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
