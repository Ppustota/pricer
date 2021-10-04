package zura.pustota.pricer.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import zura.pustota.pricer.model.Product;
import zura.pustota.pricer.service.ProductService;

import java.util.List;

import static org.springframework.http.MediaType.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/price", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductInLari(@RequestParam String name){
        Product product = productService.findByName(name);
        Double currency = restTemplate.getForObject("http://localhost:8080/api/values/" + product.getCurrency().toUpperCase(), Double.class);
        if(currency ==null){
            throw new UnsupportedOperationException("Can't get currency");
        }
        new Product();
        return ResponseEntity.ok().body(
          Product.builder().id(null)
                  .name(product.getName())
                  .price(currency*product.getPrice())
                  .currency("GEL").build()
        );
    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok().body(productService.findALl());
    }
}
