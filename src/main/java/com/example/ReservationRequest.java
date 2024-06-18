package com.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequest {
    private Long tableId;
    private Long restaurantId;
    private String username;
    private LocalDate date;
    private LocalTime time;

    public ReservationRequest() {
    }

    public ReservationRequest(Long tableId, Long restaurantId;, String username, LocalDate date, LocalTime time) {
        this.tableId = tableId;
        this.restaurantId = restaurantId;
        this.username = username;
        this.date = date;
        this.time = time;
    }
    
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
    
    
}
