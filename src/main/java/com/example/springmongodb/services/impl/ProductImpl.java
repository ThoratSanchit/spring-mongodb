package com.example.springmongodb.services.impl;

import com.example.springmongodb.models.Product;
import com.example.springmongodb.reposotories.ProductRepository;
import com.example.springmongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product saveData(Product product){
       return productRepository.save(product);

    }
    @Override
    public List<Product> getAllData(){
        return productRepository.findAll();
    }

    @Override
    public Product getDataId(String id){
        Optional<Product> isExist=productRepository.findById(id);
   return  isExist.orElse(null);
    }
    @Override
    public String update(String id,Product product){
        Optional<Product> existProduct=productRepository.findById(id);
        if(existProduct.isPresent()){
          Product updatePro=existProduct.get();
            updatePro.setName(product.getName());
            updatePro.setPrice(product.getPrice());
            updatePro.setType(product.getType());
          productRepository.save(updatePro);
          return "id "+id+" Updated";


        }else{
            return "Invalid id";
        }
    }
    @Override
    public void deleteData(String id){
         productRepository.deleteById(id);

    }
}
