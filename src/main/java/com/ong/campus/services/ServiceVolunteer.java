package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.repositories.entities.Volunteer;

@Service
public interface ServiceVolunteer {

        List<Volunteer> findAll();

        Volunteer findById(Long id) ;

        Volunteer save(Volunteer volunteer);

        Volunteer update(Long id, Volunteer volunteer);

        void delete(Long id);

}
