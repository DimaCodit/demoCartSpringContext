import java.util.List;

public interface Cart {

    void addProduct(String productId);

    void removeProduct(String productId);

    public List<Product> getAll();

}
