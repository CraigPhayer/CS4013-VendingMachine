import java.util.Objects;

/**
 * A product in a vending machine.
 */
public class Product {
    private String description;
    private double price;
    private int quantity;

    /**
     * Constructs a Product object
     *
     * @param aDescription the description of the product
     * @param aPrice       the price of the product
     */
    public Product(String aDescription, double aPrice) {
        description = aDescription;
        price = aPrice;
    }

    public String getDescription() {
        return description;
    }

    public boolean equals(Product o) {
        if (this == o) {
            return true;
        }
        if (o.description.equals(description) && o.price == price)
            return true;
        return false;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name: " + description + " , Price: " + price + " , Quantity: " + quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, price, quantity);
    }
}
