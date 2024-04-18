package com.example.bank_management_system.practice.Controller;


import com.example.bank_management_system.practice.DTO.productDto;
import com.example.bank_management_system.practice.Exception.NotFoundException;
import com.example.bank_management_system.practice.Service.productService;
import com.example.bank_management_system.practice.model.product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {
    private productService prodService;
    public void productService(productService prodService){ //dependency injection by constructor
        this.prodService = prodService;
    }
    //get a product based on ID
    @GetMapping(path="/{id}")
    public @ResponseBody product getProductById(@PathVariable("id") int id) throws Exception {
        //productService ps = new productService(); //this is not good approach to do call your object here.
        //here comes the dependency injection by constructors.

        return productService.getProductById(id);

    }
 //get all the data in of products
    @GetMapping(path="")
    public @ResponseBody List<productDto> getProductById(){
        //productService ps = new productService(); //this is not good approach to do call your object here.
        //here comes the dependency injection by constructors.
        return productService.getProductAll();

    }

    @PostMapping(path="")
    public String creatProduct(@RequestBody product prod ){
        System.out.print(prod.getCategory());
        System.out.print(prod.getTitle());
        System.out.print(prod.getImage());
        return "some good news";

    }
}
