package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private int chairs;
    private Long restaurantId;

    public Table() {
    }

    public Table(Long id, int chairs, Long restaurantId) {
        this.id = id;
        this.chairs = chairs;
        this.restaurantId = restaurantId;
    }


    public int getChairs() {
        return chairs;
    }


    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setChairs(int chairs) {
        this.chairs = chairs;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
