package pl.britenet.campus.springprojekt1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.Product;
import pl.britenet.campus.service.ProductService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("null")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable int productId) {
        return this.productService.getProduct(productId);
    }

    @GetMapping
    public List<Product> getProducts() {
        return this.productService.getProducts();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        this.productService.insertProduct(product);
    }

    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        this.productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        this.productService.deleteProduct(productId);
    }

}
