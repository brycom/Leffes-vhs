package LeffesVHS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vhs_movie")
public class VhsMovie {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Price can't be empty")
    private double price;

    @NotEmpty(message = "Name can't be empty")
    private String name;

    @NotNull(message = "inventoryAmount needs to be set")
    private int inventoryAmount;

    private String category;

    private String imageUrl;

    @Column(length = 65535,columnDefinition="Text")
    private String description;

    private boolean deleted;

    private String stripeId;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public VhsMovie() {

    }

    public VhsMovie(@NotNull(message = "Price can't be empty") double price,
            @NotEmpty(message = "Name can't be empty") String name,
            @NotNull(message = "inventoryAmount needs to be set") int inventoryAmount, String category,
            String imageUrl, String description, boolean deleted, String stripeId) {
        this.price = price;
        this.name = name;
        this.inventoryAmount = inventoryAmount;
        this.category = category;
        this.imageUrl = imageUrl;
        this.description = description;
        this.deleted = false;
        this.stripeId = stripeId;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }
}
