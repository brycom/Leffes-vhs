package LeffesVHS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "vhs_player")
public class VhsPlayer {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Price can't be empty")
    private double price;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotEmpty(message = "inventoryAmount needs to be set")
    private int inventoryAmount;

    private String imageUrl;

    private String description;

    private boolean deleted;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public VhsPlayer() {

    }

    public VhsPlayer(@NotEmpty(message = "Price can't be empty") double price,
            @NotEmpty(message = "Name can't be empty") String name,
            @NotEmpty(message = "inventoryAmount needs to be set") int inventoryAmount, String imageUrl,
            String description, boolean deleted) {
        this.price = price;
        this.name = name;
        this.inventoryAmount = inventoryAmount;
        this.imageUrl = imageUrl;
        this.description = description;
        this.deleted = false;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
