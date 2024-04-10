
package com.ong.campus.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.*;
import com.ong.campus.repositories.entities.*;
import com.ong.campus.services.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ServiceProductImpl implements ServiceProduct {

    private ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> productCurrentOptional = productRepository.findById(id);

        if(productCurrentOptional.isPresent()) {
            Product productCurrent = productCurrentOptional.get();
            productCurrent.setName(product.getName());
            productRepository.save(productCurrent);
            return productCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Product> productOptional=productRepository.findById(id);
        if(productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
        }   
    }

    @Override
    public Product findById(Long id) throws BussinesRuleException {
        Optional<Product> productOptional = productRepository.findById(id);
        if(!productOptional.isPresent()) {
            BussinesRuleException exception= new BussinesRuleException("1001","Error! Product doesn't exist",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return productOptional.get();
    }

}
