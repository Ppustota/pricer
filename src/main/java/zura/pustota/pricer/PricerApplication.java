package zura.pustota.pricer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import zura.pustota.pricer.model.Product;
import zura.pustota.pricer.repo.ProductRepo;
import zura.pustota.pricer.service.ProductService;

@SpringBootApplication
public class PricerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PricerApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductService productService){
        return args -> {
          productService.save(Product.builder().id(null).name("Coke").currency("USD").price(1D).build());
          productService.save(Product.builder().name("Pepsi").currency("EUR").price(2D).build());
        };
    }

}
