package com.example;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "restaurant_user")
public class RestaurantUser {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true)
    private String username;


    @OneToMany(mappedBy = "restaurantUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;

    public RestaurantUser() {
    }

    public RestaurantUser(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
