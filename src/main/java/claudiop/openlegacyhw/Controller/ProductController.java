package claudiop.openlegacyhw.Controller;

import claudiop.openlegacyhw.Model.Product;
import claudiop.openlegacyhw.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/items")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());

    }

    @GetMapping("/items/{itemNumber}")
    public ResponseEntity<Product> getProductById(@PathVariable("itemNumber") Long productId){
        return ResponseEntity.ok().body(productService.getProductById(productId));
        }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.createItem(product));

    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateItem(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.updateItem(product));

    }

    @PutMapping("/withdraw")
    public ResponseEntity<Product> withdraw(Long productId, Long amount){
        return ResponseEntity.ok().body(this.productService.withdraw(productId, amount));

    }

    @DeleteMapping("/items/{itemNumber}")
    public HttpStatus deleteProduct(@PathVariable ("itemNumber")Long itemNumber){
        this.productService.deleteProduct(itemNumber);
        return HttpStatus.OK;
    }


}
