package com.ong.campus.dto;

import com.ong.campus.controllers.VolunteerController;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VolunteerDTO {
    private Long id;
    @JsonView(VolunteerController.class)
    private String address;

    private Long directorId;
    @JsonView(VolunteerController.class)
    private String directorName;
}
