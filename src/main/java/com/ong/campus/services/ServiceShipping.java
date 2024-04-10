package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.Shipping;

@Service
public interface ServiceShipping {

    List<Shipping> findAll();

    Shipping findById(Long id) throws BussinesRuleException;
    
    List<Shipping> findByFinished(Boolean state) throws BussinesRuleException;

    List<Shipping> findByCampusesId(Long CampusId) throws BussinesRuleException;

    Shipping save(Shipping Shipping);

    Shipping update(Long id, Shipping Shipping);

    void delete(Long id);
}
    