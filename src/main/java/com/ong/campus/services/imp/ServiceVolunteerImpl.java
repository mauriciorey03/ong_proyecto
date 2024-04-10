
package com.ong.campus.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.campus.repositories.*;
import com.ong.campus.repositories.entities.*;
import com.ong.campus.services.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVolunteerImpl implements ServiceVolunteer {

    private VolunteerRepository repositoryVolunteer;

    @Override
    @Transactional(readOnly = true)
    public List<Volunteer> findAll() {
        return (List<Volunteer>) repositoryVolunteer.findAll();
    }

    @Override
    public Volunteer save(Volunteer volunteer) {
        return repositoryVolunteer.save(volunteer);
    }

    @Override
    public void delete(Long id) {
        Optional<Volunteer> volunteerOptional=repositoryVolunteer.findById(id);
        if(volunteerOptional.isPresent()){
            repositoryVolunteer.delete(volunteerOptional.get());
        }   
    }

    @Override
    public Volunteer findById(Long id) {
        Optional<Volunteer> volunteerOptional = repositoryVolunteer.findById(id);
        if(!volunteerOptional.isPresent()){
        }
        return volunteerOptional.get();
    }

    @Override
    public Volunteer update(Long id, Volunteer volunteer) {
        Optional<Volunteer> volunteerCurrentOptional = repositoryVolunteer.findById(id);

        if(volunteerCurrentOptional.isPresent()){
            Volunteer volunteerCurrent = volunteerCurrentOptional.get();
            volunteerCurrent.setVolunteer(volunteer.getVolunteer());
            repositoryVolunteer.save(volunteerCurrent);
            return volunteerCurrent;
        }
        return volunteer;
    }
}