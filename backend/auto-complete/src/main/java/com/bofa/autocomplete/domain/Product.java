package com.bofa.autocomplete.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="product")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private  int quantity;
    private String status;
}
