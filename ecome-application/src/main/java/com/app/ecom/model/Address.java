package com.app.ecom.model;

import jakarta.persistence.*;

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

}
