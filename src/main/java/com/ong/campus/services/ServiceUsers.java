package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.Users;

@Service
public interface ServiceUsers {
    
        List<Users> findAll();
    
        Users findById(Long id) throws BussinesRuleException;
        ;
    
        Users save(Users users);
    
        Users update(Long id, Users users);
    
        void delete(Long id);
    
    
}
