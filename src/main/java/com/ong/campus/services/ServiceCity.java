package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.repositories.entities.City;

@Service
public interface ServiceCity {

        List<City> findAll();
        City findById(Long id); 
        City save(City city);
        City update(Long id, City city);
        void delete(Long id);

}
