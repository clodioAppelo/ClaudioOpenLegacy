package claudiop.openlegacyhw.Service;

import claudiop.openlegacyhw.Exeptions.ResourceNotFoundException;
import claudiop.openlegacyhw.Model.Product;
import claudiop.openlegacyhw.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createItem(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateItem(Product product) {

        Optional<Product> productDb = this.productRepository.findById(product.getItemNumber());
        if (productDb.isPresent()) {
            Product productUpdate = productDb.get();
            productUpdate.setItemNumber(product.getItemNumber());
            productUpdate.setItemName(product.getItemName());
            productUpdate.setAmount(product.getAmount());
            productRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Item not found with id : " + product.getItemNumber());
        }

    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productDb = productRepository.findById(productId);
        if (productDb.isPresent()) {
            return productDb.get();

        } else {
            throw new ResourceNotFoundException("Item not found with id : " + productId);

        }
    }

    @Override
    public void deleteProduct(Long productId) {
        Optional<Product> productDb = this.productRepository.findById(productId);
        if (productDb.isPresent()) {
            this.productRepository.delete(productDb.get());

        } else {
            throw new ResourceNotFoundException("Item not found with id : " + productId);

        }

    }

    @Override
    public Product withdraw(Long productId, Long amount) {
        Optional<Product> productDb = this.productRepository.findById(productId);
        if (productDb.isPresent()) {
            Product productToWithdraw = productDb.get();
            Long currentAmount = productToWithdraw.getAmount();
            Long finalAmount = currentAmount - amount;
            productToWithdraw.setAmount(Math.max(0, finalAmount));
            productRepository.save(productToWithdraw);
            return productToWithdraw;
        } else {
            throw new ResourceNotFoundException("Item not found with id : " + productId);

        }

    }
}