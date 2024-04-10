
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

public class ServiceOccupationImpl implements ServiceOccupation {

    private OccupationRepository occupationRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Occupation> findAll() {
        return (List<Occupation>) occupationRepository.findAll();
    }

    @Override
    public Occupation save(Occupation occupation) {
        return occupationRepository.save(occupation);
    }

    @Override
    public Occupation update(Long id, Occupation occupation) {
        Optional<Occupation> occupationCurrentOptional = occupationRepository.findById(id);

        if(occupationCurrentOptional.isPresent()) {
            Occupation occupationCurrent = occupationCurrentOptional.get();
            occupationCurrent.setName(occupation.getName());
            occupationRepository.save(occupationCurrent);
            return occupationCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Occupation> occupationOptional=occupationRepository.findById(id);
        if(occupationOptional.isPresent()) {
            occupationRepository.delete(occupationOptional.get());
        }   
    }

    @Override
    public Occupation findById(Long id) throws BussinesRuleException {
        Optional<Occupation> occupationOptional = occupationRepository.findById(id);
        if(!occupationOptional.isPresent()) {
            BussinesRuleException exception= new BussinesRuleException("1001","Error! Occupation doesn't exist",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return occupationOptional.get();
    }

}
