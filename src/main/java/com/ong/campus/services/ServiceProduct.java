package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.Product;

@Service
public interface ServiceProduct {
    
        List<Product> findAll();
    
        Product findById(Long id) throws BussinesRuleException;
    
        Product save(Product product);
    
        Product update(Long id, Product product);
    
        void delete(Long id);
    
    }


