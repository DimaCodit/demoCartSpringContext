import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("Cart")
public class CartImpl implements Cart{

    ProductRepository productRepository;

    Map<String,Product> products =  new HashMap<>();

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(String productId) {
        Product product = productRepository.getProductById(productId);
        if (product != null) {
            products.put(product.getId(), product);
        }
    }

    @Override
    public void removeProduct(String productId) {
        products.remove(productId);
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products.values());
    }
}
