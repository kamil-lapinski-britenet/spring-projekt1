package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.OrderProducts;
import pl.britenet.campus.service.OrderProductsService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/orderProducts")
public class OrderProductsController {
    @Autowired
    public OrderProductsController(OrderProductsService orderProductsService) {
        this.orderProductsService = orderProductsService;
    }

    private final OrderProductsService orderProductsService;

    @GetMapping("/{id}")
    public Optional<OrderProducts> getOrderProduct(@PathVariable int id) {
        return this.orderProductsService.getOrderProduct(id);
    }

    @GetMapping
    public List<OrderProducts> getOrderProducts() {
        return this.orderProductsService.getOrderProducts();
    }

    @PostMapping
    public void InsertOrderProduct(@RequestBody OrderProducts t) {
        this.orderProductsService.insertOrderProduct(t);
    }

    @PutMapping
    public void updateOrderProduct(@RequestBody OrderProducts t) {
        this.orderProductsService.updateOrderProduct(t);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderProduct(@PathVariable int id) {
        this.orderProductsService.deleteOrderProduct(id);
    }
}
