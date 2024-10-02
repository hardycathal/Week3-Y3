package ie.atu.week3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    public ProductController(){
        productList.add(new Product("TV", "Big tv", 500, 1));
        productList.add(new Product("Phone", "Smart phone", 699, 2));
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productList;
    }

    @PostMapping("addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product){
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable int id){
        for(int i = 0; i < productList.size(); i++){
            if(id == productList.get(i).getId()){
                productList.remove(i);
                break;
            }
        }
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/put")
    public ResponseEntity<List> updateProduct(@RequestBody Product product){
        for(int i = 0; i < productList.size(); i++){
            if(product.getId() == productList.get(i).getId()){
                productList.set(i, product);
                break;
            }
        }

        return ResponseEntity.ok(productList);
    }


}
