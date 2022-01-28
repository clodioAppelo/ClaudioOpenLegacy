package claudiop.openlegacyhw.Service;

import claudiop.openlegacyhw.Model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product createItem(Product product);

    Product updateItem(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long productId);

    void deleteProduct(Long id);

    Product withdraw(Long productId, Long amount);
}
