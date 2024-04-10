
package com.ong.campus.services.servicesimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campus.ong.config.CampusDTOConverter;
import com.campus.ong.dto.CampusDTO;
import com.campus.ong.repositories.*;
import com.campus.ong.repositories.entities.*;
import com.campus.ong.services.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceQuota_typeImpl implements ServiceQuota_type {

    private Quota_typeRepository Quota_typerepository;

    @Override
    @Transactional(readOnly = true)
    public List<Quota_type> findAll() {
        return (List<Quota_type>) repository<built-in method lower of str object at 0x0000016CD9D736F0>.findAll();
    }

    @Override
    public Quota_type save(Quota_type Quota_type) {
        return repositoryQuota_type.save(Quota_type);
    }

    @Override
    public Quota_type update(Long id, Quota_type Quota_type) {
        Optional<Quota_type> Quota_typeCurrentOptional = repositoryQuota_type.findById(id);

        if(Quota_typeCurrentOptional.isPresent()){
            Quota_type Quota_typeCurrent = Quota_typeCurrentOptional.get();
            Quota_typeCurrent.setName(Quota_type.getName());
            repositoryQuota_type.save(Quota_typeCurrent);
            return Quota_typeCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Quota_type> Quota_typeOptional=repositoryQuota_type.findById(id);
        if(Quota_typeOptional.isPresent()){
            repositoryQuota_type.delete(Quota_typeOptional.get());
        }   
    }

    @Override
    public Quota_type findById(Long id) throws BussinesRuleException {
        Optional<Quota_type> Quota_typeOptional = repositoryQuota_type.findById(id);
        if(!Quota_typeOptional.isPresent()){
            BussinesRuleException exception= new BussinesRuleException("1003","Error! Quota_type doesn't exist", HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return Quota_typeOptional.get();
    }

    public List<Quota_type> findByType(Quota_typeType type) {
        return repositoryQuota_type.findByType(type);
    }

}
