package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private Long tableId;
    private Long userId;
    private String date;
    private String time;

    public Reservation() {
    }

    public Reservation(Long id, Long tableId, Long userId, String date, String time) {
        this.id = id;
        this.tableId = tableId;
        this.userId = userId;
        this.date = date;
        this.time = time;
    }

    public Long getTableId() {
        return tableId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
