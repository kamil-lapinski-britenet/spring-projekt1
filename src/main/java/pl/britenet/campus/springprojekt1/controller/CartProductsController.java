package pl.britenet.campus.springprojekt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.britenet.campus.database.object.CartProducts;
import pl.britenet.campus.service.CartProductsService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/cartProducts")
public class CartProductsController {

    private final CartProductsService cartProductsService;
    @Autowired
    public CartProductsController(CartProductsService cartProductsService) {
        this.cartProductsService = cartProductsService;
    }


    @GetMapping("/{id}")
    public Optional<CartProducts> getCartProducts(@PathVariable int id) {
        return this.cartProductsService.getCartProduct(id);
    }

    @GetMapping
    public List<CartProducts> getCartProduct() {
        return this.cartProductsService.getCartsProducts();
    }

    @PostMapping
    public void InsertCartProduct(@RequestBody CartProducts t) {
        this.cartProductsService.insertCartProduct(t);
    }

    @PutMapping
    public void updateCartProduct(@RequestBody CartProducts t) {
        this.cartProductsService.updateCartProduct(t);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartProduct(@PathVariable int id) {
        this.cartProductsService.deleteCartProduct(id);
    }


}
