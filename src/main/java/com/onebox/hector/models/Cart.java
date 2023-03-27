package com.onebox.hector.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
public class Cart {
    private int id;

    private List<Product> products;

    private LocalDateTime creationTime;

    public Cart() {
        products = new ArrayList<Product>();
        creationTime = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isExpired() {
        return creationTime.plusMinutes(1).isBefore(LocalDateTime.now());
    }
}
