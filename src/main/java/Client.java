import jdk.nashorn.internal.ir.WhileNode;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Cart cart = context.getBean("Cart", Cart.class);
        ProductRepository repository = context.getBean("ProductRepository", ProductRepository.class);

        System.out.println("Доступные товары:");
        for (Product product:repository.getProducts() ) {
            System.out.println(product.getTitle() + "\t идентификатор: " + product.getId() + " цена: " + product.getCost());
        }
        System.out.println("Добавить товар в корзину: add id");
        System.out.println("Удалить товар из корзины: remove id");
        System.out.println("Просмотрет корзину: all");
        System.out.println("Выход: q");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String s = scanner.nextLine();

            String[] params = s.toLowerCase().split(" ");

            if (params[0].trim().equals("add") && params.length > 1) {
                cart.addProduct(params[1]);
            } else if (params[0].trim().equals("remove") && params.length > 1) {
                cart.removeProduct(params[1]);
            } else if (params[0].trim().equals("all")) {

                System.out.println("Товары в корзине:");
                List<Product> productList = cart.getAll();
                if (productList == null) return;
                for (Product product : cart.getAll()) {
                    System.out.println(product.getTitle() + "\t идентификатор: " + product.getId() + " цена: " + product.getCost());
                }

            }
        }
    }
}

