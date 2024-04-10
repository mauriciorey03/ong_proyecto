package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.VolunteerH;

@Service
public interface ServiceVolunteerH {
    
        List<VolunteerH> findAll();
    
        VolunteerH findById(Long id) throws BussinesRuleException;
    
        VolunteerH save(VolunteerH volunteer_h);
    
        VolunteerH update(Long id, VolunteerH volunteer_h);
    
        void delete(Long id);

}
