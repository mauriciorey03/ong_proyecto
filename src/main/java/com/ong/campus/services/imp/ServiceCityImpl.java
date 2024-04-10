
package com.ong.campus.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.campus.repositories.*;
import com.ong.campus.repositories.entities.*;
import com.ong.campus.services.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ServiceCityImpl implements ServiceCity {

    private CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City update(Long id, City city) {
        Optional<City> cityCurrentOptional = cityRepository.findById(id);

        if(cityCurrentOptional.isPresent()) {
            City cityCurrent = cityCurrentOptional.get();
            cityCurrent.setName(city.getName());
            cityRepository.save(cityCurrent);
            return cityCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<City> cityOptional=cityRepository.findById(id);
        if(cityOptional.isPresent()) {
            cityRepository.delete(cityOptional.get());
        }   
    }

    @Override
    public City findById(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if(!cityOptional.isPresent()) {
        }
        return cityOptional.get();
    }

}
