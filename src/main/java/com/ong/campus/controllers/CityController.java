package com.ong.campus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ong.campus.config.CityDTOConverter;
import com.ong.campus.dto.CityDTO;
import com.ong.campus.repositories.entities.City;
import com.ong.campus.services.ServiceCity;

@RestController
@RequestMapping("/cities/")
public class CityController {

    @Autowired
    private ServiceCity cityService;

    @Autowired
    private CityDTOConverter cityDTOConverter;

    @GetMapping
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<City> cities = cityService.findAll();
        List<CityDTO> cityDTOs = cities.stream()
                .map(cityDTOConverter::convertCityDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(cityDTOs);
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityDTO> getCity(@PathVariable Long cityId) {
        City city = cityService.findById(cityId);
        CityDTO cityDTO = cityDTOConverter.convertCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @PostMapping
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) {
        City city = cityDTOConverter.convertCityEntity(cityDTO);
        City savedCity = cityService.save(city);
        CityDTO savedCityDTO = cityDTOConverter.convertCityDTO(savedCity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCityDTO);
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityDTO> updateCity(@PathVariable Long cityId, @RequestBody CityDTO cityDTO) {
        City city = cityDTOConverter.convertCityEntity(cityDTO);
        City updatedCity = cityService.update(cityId, city);
        CityDTO updatedCityDTO = cityDTOConverter.convertCityDTO(updatedCity);
        return ResponseEntity.ok(updatedCityDTO);
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<?> deleteCity(@PathVariable Long cityId) {
        cityService.delete(cityId);
        return ResponseEntity.noContent().build();
    }
}