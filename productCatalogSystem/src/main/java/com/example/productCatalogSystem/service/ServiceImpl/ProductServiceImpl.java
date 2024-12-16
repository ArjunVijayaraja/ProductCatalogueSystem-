package com.example.productCatalogSystem.service.ServiceImpl;

import com.example.productCatalogSystem.dto.ProductDto;
import com.example.productCatalogSystem.entity.Product;
import com.example.productCatalogSystem.exception.ProductAlreadyExistException;
import com.example.productCatalogSystem.repository.ProductRepository;
import com.example.productCatalogSystem.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

//    @Override
//    public ProductDto createProduct(@RequestBody ProductDto productDto) {
//        Optional<Product> optionalProduct =  productRepository.findByProductname(productDto.getProductname());
//        if(optionalProduct.isPresent()){
//            throw new ProductAlreadyExistException(productDto.getProductname());
//        }
//        productDto.setEntrydate(LocalDateTime.now());
//
//        Product mappedProduct =  modelMapper.map(productDto, Product.class);
//        Product savedProd = productRepository.save(mappedProduct);
//        return modelMapper.map(savedProd, ProductDto.class);
//    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Optional<Product> optionalProduct =  productRepository.findByProductname(productDto.getProductname());
        if(optionalProduct.isPresent()){
            throw new ProductAlreadyExistException(productDto.getProductname());
        }
        productDto.setEntrydate(LocalDateTime.now());

        Product mappedProduct =  modelMapper.map(productDto, Product.class);
        Product savedProd = productRepository.save(mappedProduct);
        return modelMapper.map(savedProd, ProductDto.class);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        List<ProductDto> productsDto = products.stream().map(prod->modelMapper.map(prod,ProductDto.class)).collect(Collectors.toList());

        return productsDto;
    }

}
