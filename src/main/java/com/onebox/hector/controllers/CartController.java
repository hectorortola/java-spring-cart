package com.onebox.hector.controllers;

import com.onebox.hector.Exception.CartNotFoundException;
import com.onebox.hector.models.Cart;
import com.onebox.hector.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping()
    public Cart createCart(@RequestBody Cart cart){
        return cartService.saveCart(cart);
    }

    @GetMapping
    public List<Cart> findAllCarts() {
        if(cartService.getCarts().isEmpty()){
            throw new CartNotFoundException();
        }
        return cartService.getCarts();
    }

    @GetMapping(path = "/{id}")
    public Cart getCartById(@PathVariable int id){
        if (cartService.getCartById(id) == null){
            throw new CartNotFoundException();
        }
        return cartService.getCartById(id);
    }

    @PutMapping(path = "/{id}")
    public Cart updateCart(@RequestBody Cart cart){
        return cartService.updateCart(cart);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCartById(@PathVariable int id){
        return cartService.deleteCart(id);
    }

}
