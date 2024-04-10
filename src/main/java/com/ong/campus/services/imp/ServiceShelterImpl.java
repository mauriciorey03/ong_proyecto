
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

public class ServiceShelterImpl implements ServiceShelter {

    private ShelterRepository shelterRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Shelter> findAll() {
        return (List<Shelter>) shelterRepository.findAll();
    }

    @Override
    public Shelter save(Shelter shelter) {
        return shelterRepository.save(shelter);
    }

    @Override
    public Shelter update(Long id, Shelter shelter) {
        Optional<Shelter> shelterCurrentOptional = shelterRepository.findById(id);

        if(shelterCurrentOptional.isPresent()) {
            Shelter shelterCurrent = shelterCurrentOptional.get();
            shelterCurrent.setName(shelter.getName());
            shelterRepository.save(shelterCurrent);
            return shelterCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Shelter> shelterOptional=shelterRepository.findById(id);
        if(shelterOptional.isPresent()) {
            shelterRepository.delete(shelterOptional.get());
        }   
    }

    @Override
    public Shelter findById(Long id) throws BussinesRuleException {
        Optional<Shelter> shelterOptional = shelterRepository.findById(id);
        if(!shelterOptional.isPresent()) {
            BussinesRuleException exception= new BussinesRuleException("1001","Error! Shelter doesn't exist",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return shelterOptional.get();
    }

}
