package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.service.CartService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    public Optional<Cart> getCart(@PathVariable int cartId) {
        return this.cartService.getCart(cartId);
    }

    @GetMapping
    public List<Cart> getCarts() {
        return this.cartService.getCarts();
    }

    @PostMapping
    public void createCart(@RequestBody Cart cart) {
        this.cartService.insertCart(cart);
    }

    @PutMapping
    public void updateCart(@RequestBody Cart cart) {
        this.cartService.updateCart(cart);
    }

    @DeleteMapping("/delete/{cartId}")
    public void delete(@PathVariable int cartId) {
        this.cartService.deleteCart(cartId);
    }

}
