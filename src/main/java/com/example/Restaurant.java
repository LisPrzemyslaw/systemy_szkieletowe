//package com.example;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//
//@Entity
//public class Restaurant {
//    @Id
//    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//
//    public Restaurant(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Restaurant() {
//
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number_of_tables;

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
