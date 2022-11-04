import java.util.ArrayList;

/**
 * A vending machine.
 */
public class VendingMachine {
    private ArrayList<Product> products;
    public CoinSet coins;
    public CoinSet currentCoins;

    /**
     * Constructs a VendingMachine object.
     */
    public VendingMachine() {
        products = new ArrayList<Product>();
        coins = new CoinSet();
        currentCoins = new CoinSet();
    }


    public Product[] getProductTypes() {
        int output = products.size();
        Product[] outputProducts = new Product[output];
        for (int i = 0; i < output; i++) {
            outputProducts[i] = products.get(i);
        }
        return outputProducts;
    }

    public void addProduct(Product product, int quantity) {
        if (getProduct(product) == null) {
            products.add(product);
            product.setQuantity(quantity);
        } else {
            product = getProduct(product);
            product.setQuantity(product.getQuantity() + quantity);
        }
    }

    public void buyProduct(Product p) {
        if (p.getPrice() >= currentCoins.getAmount()) {
            p.setQuantity(p.getQuantity() - 1);
            currentCoins = new CoinSet();
            if (p.getQuantity() == 0) {
                products.remove(p);
            }
        } else {
            throw new VendingException("Insufficient funds, please insert more money");
        }
    }

    public void addCoin(Coin choice) {
        currentCoins.addCoin(choice);
    }

    public String removeMoney() {
        StringBuilder str = new StringBuilder();

        for (Coin c : currentCoins.getSet()) {
            str.append(c.getName() + ", ");
        }
        if (!str.isEmpty()) {
            str.delete(str.length() - 1, str.length() - 1);
        }
        currentCoins = new CoinSet();
        return str.toString();
    }

    private Product getProduct(Product p) {
        for (Product prod : products) {
            if (prod.equals(p)) {
                return prod;
            }
        }
        return null;
    }
}