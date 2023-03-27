package com.onebox.hector.repositories;

import com.onebox.hector.models.Cart;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartRepository {

    private List<Cart> cartList = new ArrayList<Cart>();

    public Cart save(Cart c){
        Cart cart = new Cart();
        cart.setId(c.getId());
        cart.setProducts(c.getProducts());
        cartList.add(cart);
        return cart;
    }

    public String delete(int id){
        cartList.removeIf(x -> x.getId() == (id));
        return null;
    }

    public Cart update(Cart cart){
        int index = 0;

        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getId() == (cart.getId())) {
                index = i;
                break;
            }
        }

        cartList.set(index, cart);
        return cart;
    }

    public Cart findCartById(int id){
        for (Cart cart : cartList) {
            if(cart.getId() == (id)){
                if(!cart.isExpired()){
                    return cart;
                }
            }
        }
        return null;
    }

    public List<Cart> getAllCarts(){
        for (Cart cart : cartList) {
            if(cart.isExpired()){
                cartList.removeIf(x -> x.getId() == cart.getId());
                return null;
            }
        }
        return cartList;
    }
}
