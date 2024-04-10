package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.Shelter;

@Service
public interface ServiceShelter {
        
            List<Shelter> findAll();
        
            Shelter findById(Long id)throws BussinesRuleException;
        
            Shelter save(Shelter shelter);
        
            Shelter update(Long id, Shelter shelter);
        
            void delete(Long id);
        
}