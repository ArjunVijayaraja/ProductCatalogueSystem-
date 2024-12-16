package com.example.productCatalogSystem.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    @NotEmpty(message = "Product Name should not be empty")
    private String productname;
    @NotNull(message = "Product price should not be empty")
    private float productprice;
    @NotEmpty(message = "Product category should not be empty")
    private String productcategory;

    private LocalDateTime entrydate;

}
