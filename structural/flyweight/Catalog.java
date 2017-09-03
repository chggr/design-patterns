import java.util.HashMap;
import java.util.Map;

public class Catalog {

    private Map<Integer, Product> products = new HashMap<>();
    private ProductDatabase db = new ProductDatabase();

    public Product getProduct(int id) {
        return products.computeIfAbsent(id, k -> db.getProduct(k));
    }
}
