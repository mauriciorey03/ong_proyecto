package com.ong.campus.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.ong.campus.controllers.ShelterController;

import lombok.Data;

@Data
public class ShelterDTO {
    
    @JsonView(ShelterController.class)
    private Long id;

    @JsonView(ShelterController.class)
    private String name;

    private Long city_id;
    @JsonView(ShelterController.class)
    private String city_name;
    
}