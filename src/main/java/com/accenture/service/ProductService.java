package com.accenture.service;

import com.accenture.entity.Product;
import com.accenture.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }
    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product deleted!!";
    }
    public Product updateProduct(Product product){
        Product existingproduct = getProductById(product.getId());
        existingproduct.setId(product.getId());
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());
        existingproduct.setQuantity(product.getQuantity());
        return productRepository.save(existingproduct);
    }
}
