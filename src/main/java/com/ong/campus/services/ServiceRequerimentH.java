package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.RequerimentH;

@Service
public interface ServiceRequerimentH {
    
        List<RequerimentH> findAll();
    
        RequerimentH findById(Long id) throws BussinesRuleException;
    
        RequerimentH save(RequerimentH requerimenth);
    
        RequerimentH update(Long id, RequerimentH requerimenth);
    
        void delete(Long id);
    
    }


