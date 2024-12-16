package com.example.productCatalogSystem.controller;

import com.example.productCatalogSystem.exception.ProductAlreadyExistException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.productCatalogSystem.dto.ProductDto;
import com.example.productCatalogSystem.service.ProductService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

@Controller
@AllArgsConstructor
//@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

//   @GetMapping("/getAllProd")
//   public ResponseEntity<List<ProductDto>> getAllProductDetails(){
//      List<ProductDto> products =  productService.getAllProducts();
//      return new ResponseEntity<>(products, HttpStatus.OK);
//
//   }
//
//    @PostMapping("/createProduct")
//    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
//       ProductDto savedProduct =  productService.createProduct(productDto);
//        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
//    }

    @GetMapping("/")
    public String loadHomePage() {
        return "homePage";
    }

    @GetMapping("/createProd")
    public String loadAddProductPage(Model model){

        //here can i use the modelclasss
        //ProductModel productmodel = new ProductModel();
        //modelMapper.map(productmodel,ProductDto.class);
        //then pass this mapped object to the service layer???

        ProductDto productDto = new ProductDto();
        model.addAttribute("product_Dto",productDto);
        return "AddProduct";
    }

    @PostMapping("/createProd/save")
    public String saveProduct(@Valid @ModelAttribute ("product_Dto") ProductDto productDto,
                              BindingResult result,
                              Model model){

        if (result.hasErrors()) {
            model.addAttribute("product_Dto", productDto);
            return "/AddProduct";
        }

        try {
            productService.createProduct(productDto);
            return "redirect:/createProd?success";
        } catch (ProductAlreadyExistException ex) {
            model.addAttribute("product_Dto", productDto); // Add product DTO to keep the filled form
            model.addAttribute("errorMessage", "PRODUCT EXISTS ALREADY"); // Pass the error message

            return "/AddProduct";  // Redirect back to the form page with the error message
        }
        //productService.createProduct(productDto);

    }

    @GetMapping("/createProd/save")
    public String showCreateProductForm(Model model) {
        model.addAttribute("product_Dto", new ProductDto()); // Initialize a new ProductDto for the form
        return "AddProduct"; // Return the view for creating a product
    }

    @GetMapping("/viewProd")
    public String loadViewProdPage(Model model){
        List<ProductDto> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "prodViewPage";
    }




}
