package com.onebox.hector.services;

import com.onebox.hector.models.Cart;
import com.onebox.hector.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> getCarts(){
        return cartRepository.getAllCarts();
    }

    public Cart getCartById(int id){
        return cartRepository.findCartById(id);
    }

    public Cart updateCart(Cart cart){
        return cartRepository.update(cart);
    }

    public String deleteCart(int id){
        try{
            cartRepository.delete(id);
            return "Cart removed successfully! ID: " + id;
        }catch (Exception err){
            return "Error removing cart with ID: " + id;
        }
    }

}
