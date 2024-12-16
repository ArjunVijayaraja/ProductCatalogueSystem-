package com.example.productCatalogSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel{

    private String productName;
    private float productPrice;
    private String productCategory;
}
