package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.Occupation;

@Service
public interface ServiceOccupation {
    
        List<Occupation> findAll();
    
        Occupation findById(Long id) throws BussinesRuleException;

    
        Occupation save(Occupation occupation);
    
        Occupation update(Long id, Occupation occupation);
    
        void delete(Long id);
    
    }


