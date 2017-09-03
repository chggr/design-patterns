import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProductDatabase {

    public Product getProduct(int id) {
        try (BufferedReader br = new BufferedReader(new FileReader("ProductDatabase.csv"))) {
            String idString = String.valueOf(id);
            String line;
            while ((line = br.readLine()) != null) {
                String[] contents = line.split(",");
                if (contents.length == 3 && idString.equals(contents[0])) {
                    return new Product(id, contents[1], contents[2]);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        return null;
    }
}

