package com.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReservationDTO {
    private Long id;
    private Long tableId;
    private Long userId;
    private String date;
    private String time;

    public ReservationDTO() {
    }

    public ReservationDTO(Long id, Long tableId, Long userId, LocalDate date, LocalTime time) {
        this.id = id;
        this.tableId = tableId;
        this.userId = userId;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.date = date.format(dateFormatter);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.time = time.format(timeFormatter);
    }

    // Getters and setters...
}
