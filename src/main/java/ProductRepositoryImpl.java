import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("ProductRepository")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> productsList;

    public ProductRepositoryImpl() {
        init();
    }

    private void init() {
        this.productsList = Arrays.asList(
                new Product("1", "Гречка", 80),
                new Product("2", "Рис", 55),
                new Product("3", "Перловка", 33),
                new Product("4", "Манка", 25),
                new Product("5", "Пшено", 44)
        );
    }

    public List<Product> getProducts() {
        return productsList;
    }

    public Product getProductById(String id) {
        Optional<Product> product= productsList.stream().filter(p->p.getId().equals(id)).findFirst();
        return product.get();
    }

}
