package com.example.springmongodb.controllers;

import com.example.springmongodb.models.Product;
import com.example.springmongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/data")
    public Product saveData(@RequestBody Product product){
        return  this.productService.saveData(product);
    }
    @GetMapping("/getData")
    public List<Product> getAllData(){
        return  this.productService.getAllData();
    }
    @GetMapping("getData/{id}")
    public Product getDataId(@PathVariable String id){
        return  this.productService.getDataId(id);
    }
    @PutMapping("/putData/{id}")
    public String update(@PathVariable String id, @RequestBody  Product product){
        return  this.productService.update(id,product);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        productService.deleteData(id);
    }
}
