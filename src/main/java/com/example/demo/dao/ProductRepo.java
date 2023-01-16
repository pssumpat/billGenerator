package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Product;

public interface ProductRepo extends CrudRepository<Product,Integer>{

}
