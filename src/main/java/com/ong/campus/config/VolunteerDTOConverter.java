package com.ong.campus.config;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ong.campus.dto.VolunteerDTO;
import com.ong.campus.repositories.entities.Volunteer;

@Component
public class VolunteerDTOConverter {
    @Autowired
    private ModelMapper dbm;

    public VolunteerDTOConverter(ModelMapper modelMapper) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        this.dbm = modelMapper;

    }

    public VolunteerDTO convertVolunteerDTO(Volunteer volunteer){

        VolunteerDTO volunteerDTO = dbm.map(volunteer, VolunteerDTO.class);
        if(volunteer.getId() != null){
            volunteerDTO.setId(volunteer.getId());
        }
        return volunteerDTO;
    }

    public Volunteer convertVolunteerEntity(VolunteerDTO volunteerDTO){
        return dbm.map(volunteerDTO, Volunteer.class);   
    }
}