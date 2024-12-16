package com.example.productCatalogSystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;

    @Column(nullable = false)
    private String productname;

    @Column(nullable = false)
    private float productprice;

    @Column(nullable = false)
    private String productcategory;

    @Column
    private LocalDateTime entrydate;

}
