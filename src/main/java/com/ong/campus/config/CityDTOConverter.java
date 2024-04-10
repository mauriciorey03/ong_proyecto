package com.ong.campus.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ong.campus.dto.CityDTO;
import com.ong.campus.repositories.entities.City;

@Component
public class CityDTOConverter {
    @Autowired
    private ModelMapper dbm;

    public CityDTOConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;

    }

    public CityDTO convertCityDTO(City city){

        CityDTO cityDTO = dbm.map(city, CityDTO.class);
        if(city.getId() != null){
            cityDTO.setId(city.getId());
            cityDTO.setName(city.getName());
        }
        return cityDTO;
    }

    public City convertCityEntity(CityDTO cityDTO){
        return dbm.map(cityDTO, City.class);   
    }
}