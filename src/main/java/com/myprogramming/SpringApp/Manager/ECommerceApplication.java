package com.myprogramming.SpringApp.Manager;

import com.myprogramming.SpringApp.Model.Product;
import com.myprogramming.SpringApp.Records.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ECommerceApplication {

    @Autowired
    private Records records;

    @PostMapping("saveProduct")
    public Product addProduct(@RequestBody Product product){
        return records.save(product);
    }
    @GetMapping("getAllProduct")
    public List<Product> getAllProduct(){
        return records.findAll();
    }
    @GetMapping("getProduct/{id}")
    public Optional<Product> getProductById(@PathVariable int id){
        return records.findById(id);
    }
    @GetMapping("getByType/{type}")
    public List<Product> getProductByType(@PathVariable String type){
        return records.getByType(type);
    }
    @DeleteMapping("deleteProduct")
    public String deleteProduct(@PathVariable int id){
        String result;
        try{
            records.deleteById(id);
            result="product deleted";
        }catch (Exception e){
            result="error";
        }
        return result;
    }

}
