package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.Order;
import pl.britenet.campus.database.object.OrderProducts;
import pl.britenet.campus.service.OrderService;

import java.util.List;
import java.util.Optional;
@CrossOrigin("null")
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable int id) {
        return this.orderService.getOrder(id);
    }

    @GetMapping
    public List<Order> getOrders() {
        return this.orderService.getOrders();
    }

    @PostMapping
    public void insertOrder(@RequestBody Order t) {
        this.orderService.insertOrder(t);
    }

    @PutMapping
    public void updateOrder(@RequestBody Order t) {
        this.orderService.updateOrder(t);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable int id) {
        this.orderService.deleteOrder(id);
    }
}
