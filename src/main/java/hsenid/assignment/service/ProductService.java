package hsenid.assignment.service;

import hsenid.assignment.entity.Product;
import hsenid.assignment.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Product> getProductList(){
        return repository.findAll();
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed" +id;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
