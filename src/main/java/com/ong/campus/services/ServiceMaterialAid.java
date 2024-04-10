package com.ong.campus.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.entities.MaterialAid;

@Service

public interface ServiceMaterialAid {

    List<MaterialAid> findAll();

    MaterialAid findById(Long id) throws BussinesRuleException;

    MaterialAid save(MaterialAid materialaid);

    MaterialAid update(Long id, MaterialAid materialaid);

    void delete(Long id);
}
