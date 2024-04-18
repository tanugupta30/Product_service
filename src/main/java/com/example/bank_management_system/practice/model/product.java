package com.example.bank_management_system.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data //for to string method
public class product {
    private int id;
    private String name;
    private String title;
    private String image;
    private String Address;
    private Double price;
    private String category;


}
