package com.example.productCatalogSystem.service;

import com.example.productCatalogSystem.dto.ProductDto;
import com.example.productCatalogSystem.entity.Product;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();
//    ProductDto findProductByProductName(String ProductName);


}

