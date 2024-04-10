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

import com.ong.campus.config.VolunteerDTOConverter;
import com.ong.campus.dto.VolunteerDTO;
import com.ong.campus.repositories.entities.Volunteer;
import com.ong.campus.services.ServiceVolunteer;

@RestController
@RequestMapping("/volunteers/")
public class VolunteerController {

    @Autowired
    private ServiceVolunteer volunteerService;

    @Autowired
    private VolunteerDTOConverter volunteerDTOConverter;

    @GetMapping
    public ResponseEntity<List<VolunteerDTO>> getAllCities() {
        List<Volunteer> cities = volunteerService.findAll();
        List<VolunteerDTO> volunteerDTOs = cities.stream()
                .map(volunteerDTOConverter::convertVolunteerDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(volunteerDTOs);
    }

    @GetMapping("/{volunteerId}")
    public ResponseEntity<VolunteerDTO> getVolunteer(@PathVariable Long volunteerId) {
        Volunteer volunteer = volunteerService.findById(volunteerId);
        VolunteerDTO volunteerDTO = volunteerDTOConverter.convertVolunteerDTO(volunteer);
        return ResponseEntity.ok(volunteerDTO);
    }

    @PostMapping
    public ResponseEntity<VolunteerDTO> createVolunteer(@RequestBody VolunteerDTO volunteerDTO) {
        Volunteer volunteer = volunteerDTOConverter.convertVolunteerEntity(volunteerDTO);
        Volunteer savedVolunteer = volunteerService.save(volunteer);
        VolunteerDTO savedVolunteerDTO = volunteerDTOConverter.convertVolunteerDTO(savedVolunteer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVolunteerDTO);
    }

    @PutMapping("/{volunteerId}")
    public ResponseEntity<VolunteerDTO> updateVolunteer(@PathVariable Long volunteerId, @RequestBody VolunteerDTO volunteerDTO) {
        Volunteer volunteer = volunteerDTOConverter.convertVolunteerEntity(volunteerDTO);
        Volunteer updatedVolunteer = volunteerService.update(volunteerId, volunteer);
        VolunteerDTO updatedVolunteerDTO = volunteerDTOConverter.convertVolunteerDTO(updatedVolunteer);
        return ResponseEntity.ok(updatedVolunteerDTO);
    }

    @DeleteMapping("/{volunteerId}")
    public ResponseEntity<?> deleteVolunteer(@PathVariable Long volunteerId) {
        volunteerService.delete(volunteerId);
        return ResponseEntity.noContent().build();
    }
}