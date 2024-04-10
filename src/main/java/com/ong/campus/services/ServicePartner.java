package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.repositories.entities.Partner;

@Service
public interface ServicePartner {
    
        List<Partner> findAll();
    
        Partner findById(Long id);
    
        Partner save(Partner partner);
    
        Partner update(Long id, Partner partner);
    
        void delete(Long id);
    
    }


