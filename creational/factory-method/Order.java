import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Order {

    private Map<Product, Integer> cart = new HashMap<>();
    private boolean expedited = false;

    public void add(Product product, int quantity) {
        Integer existing = cart.get(product);
        cart.put(product, existing == null ? quantity : quantity + existing);
    }

    public Map<Product, Integer> getCart() {
        return Collections.unmodifiableMap(this.cart);
    }

    public void setExpedited(boolean expedited) {
        this.expedited = expedited;
    }

    public boolean isExpedited() {
        return this.expedited;
    }
}

