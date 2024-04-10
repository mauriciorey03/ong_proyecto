package com.ong.campus.dto;

import com.ong.campus.controllers.CityController;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    private Long id;
    @JsonView(CityController.class)
    private String name;
}