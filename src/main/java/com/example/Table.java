package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Table {
    @Id
    private Long id;
    private int chairs;
    private boolean isReserved;
    private Long restaurantId;
    private Long userId;
    private Long reservationId;

    public Table() {
    }

    public Table(Long id, int chairs, boolean isReserved, Long restaurantId, Long userId) {
        this.id = id;
        this.chairs = chairs;
        this.isReserved = isReserved;
        this.restaurantId = restaurantId;
        this.userId = userId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getChairs() {
        return chairs;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
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
