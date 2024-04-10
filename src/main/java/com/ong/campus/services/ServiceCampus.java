package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.dto.CampusDTO;
import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.*;

@Service
public interface ServiceCampus {
    
        List<CampusDTO> findAll();
    
        CampusDTO findById(Long id) throws BussinesRuleException;
    
        CampusDTO save(CampusDTO campus);
    
        Campus update(Long id, Campus campus);
    
        void delete(Long id);
    
    }
