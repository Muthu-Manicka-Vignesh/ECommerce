package com.myprogramming.SpringApp.Records;

import com.myprogramming.SpringApp.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Records extends JpaRepository<Product,Integer> {
    public List<Product> getByType(String type);
}
