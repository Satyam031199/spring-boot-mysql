package com.accenture.controller;

import com.accenture.entity.Product;
import com.accenture.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @PostMapping("/saveProducts")
    public List<Product> saveProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }
    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping("/getProduct/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/getProductByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}
