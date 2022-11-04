import java.util.ArrayList;

/**
 * A set of coins.
 */
public class CoinSet {
    private ArrayList<Coin> set;

    /**
     * Constructs a CoinSet object.
     */
    public CoinSet() {
        set = new ArrayList<Coin>();
    }

    public double getAmount() {
        int total = 0;

        for (Coin c : set) {
            total += c.getValue();
        }
        return total;
    }

    public void addCoin(Coin coin) {
        set.add(coin);
    }

    public ArrayList<Coin> getSet() {
        return set;
    }
}