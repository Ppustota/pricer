package zura.pustota.pricer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import zura.pustota.pricer.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Product findByName(String name);

}
