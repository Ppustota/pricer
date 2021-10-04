package zura.pustota.pricer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zura.pustota.pricer.model.Product;
import zura.pustota.pricer.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
        private final ProductRepo productRepo;
    @Override
    public List<Product> findALl() {
        return productRepo.findAll();
    }

    @Override
    public Product findByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        Optional<Product> byId = productRepo.findById(id);
        if(byId.isEmpty())
            throw new RuntimeException();
        productRepo.delete(byId.get());
    }
}
