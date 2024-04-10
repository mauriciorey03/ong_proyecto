package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.QuotaType;

@Service
public interface ServiceQuotaType {
    
        List<QuotaType> findAll();
    
        QuotaType findById(Long id) throws BussinesRuleException;
    
        QuotaType save(QuotaType quotatype);
    
        QuotaType update(Long id, QuotaType quotatype);
    
        void delete(Long id);
    
    }

