package com.example.springmongodb.services;

import com.example.springmongodb.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductService {
    public Product saveData(Product product);

    public List<Product> getAllData();

    public Product getDataId(String id);
    public String update(String id, Product product);
    public  void deleteData(String id);

}
