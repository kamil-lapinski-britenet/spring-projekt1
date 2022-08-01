package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.Cart;
import pl.britenet.campus.service.CartService;
import pl.britenet.campus.springprojekt1.service.AuthenticationService;

import java.util.List;
import java.util.Optional;
@CrossOrigin("null")
@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;
    private final AuthenticationService authenticationService;

    @Autowired
    public CartController(CartService cartService, AuthenticationService authenticationService) {
        this.cartService = cartService;
        this.authenticationService = authenticationService;
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
    public void createCart(@RequestHeader("Authorization") String user_token,@RequestBody Cart cart ) {
        System.out.println("Token: " + user_token);
       //int user_id = authenticationService.getUserId(user_token);


     //   System.out.println("Retrieved User ID: " + user_id);
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

