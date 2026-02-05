package com.app.ecom.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address_table")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String country;
    private String zipcode;
    private String state;

}
