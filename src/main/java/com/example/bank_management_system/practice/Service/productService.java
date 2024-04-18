package com.example.bank_management_system.practice.Service;

import com.example.bank_management_system.practice.DTO.productDto;
import com.example.bank_management_system.practice.Exception.NotFoundException;
import com.example.bank_management_system.practice.model.product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class productService {

   public static product getProductById(int id) throws NotFoundException {

      RestTemplate rest=new RestTemplate();
      String url ="https://fakestoreapi.com/products/"+id;
      product prod= rest.getForObject(url, product.class);
      if(prod==null){
         throw new NotFoundException();
      }
      System.out.print("testin"+prod);

      return prod;

   }

   public static productDto convertToDto(product prod){

      productDto dto= new productDto();
      dto.setId(prod.getId());
      dto.setTitle(prod.getTitle());
      dto.setImage(prod.getImage());
      dto.setPrice(prod.getPrice());
      return dto;

   }
   public static List<productDto> getProductAll(){
      // 1.make a call 3rd party API
      // 2. Desrialize into java objects
      // 3. Convert the array into array/list of dto objects
      RestTemplate rest=new RestTemplate();
      String url ="https://fakestoreapi.com/products/";
      product[] prod= rest.getForObject(url, product[].class); //for deserialize we cannot use generic, only we can use it primitive types
      List<productDto> res=new ArrayList<>();
      for(product i : prod){
         res.add(convertToDto(i));
      }
      return res;

   }
}
