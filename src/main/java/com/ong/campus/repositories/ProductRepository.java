package com.ong.campus.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ong.campus.repositories.entities.*;


public interface ProductRepository extends CrudRepository<Product, Long> {
    
}