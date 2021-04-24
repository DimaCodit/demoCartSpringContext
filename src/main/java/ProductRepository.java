import java.util.List;

public interface ProductRepository {

    public List<Product> getProducts();

    public Product getProductById(String id);

}
