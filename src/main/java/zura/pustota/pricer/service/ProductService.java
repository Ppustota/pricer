package zura.pustota.pricer.service;

import zura.pustota.pricer.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findALl();
    Product findByName(String name);
    void save(Product product);
    void delete(Long id);
}
