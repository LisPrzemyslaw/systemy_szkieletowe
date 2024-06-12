package com.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "number_of_tables", nullable = false)
    private int number_of_tables;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Table> tables;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public int getNumber_of_tables() {
        return number_of_tables;
    }

    public void setNumber_of_tables(int number_of_tables) {
        this.number_of_tables = number_of_tables;
    }

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Restaurant() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
