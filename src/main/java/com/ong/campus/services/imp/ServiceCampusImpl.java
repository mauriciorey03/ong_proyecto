
package com.ong.campus.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.campus.config.CampusDTOConverter;
import com.ong.campus.dto.CampusDTO;
import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.*;
import com.ong.campus.repositories.entities.*;
import com.ong.campus.services.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceCampusImpl implements ServiceCampus{
    
    @Autowired
    private CampusRepository campusRepository;
    private UsersRepository UsersRepository;
    private CityRepository cityRepository;
    
    @Autowired
    private CampusDTOConverter convert;

    @Override
    @Transactional(readOnly = true)
    public List<CampusDTO> findAll() {
        List<Campus> campuses = (List<Campus>) campusRepository.findAll();
        return campuses.stream()
                    .map(campus->convert.convertCampusDTO(campus))
                    .toList();

    }

    @Override
    public CampusDTO findById(Long id) throws BussinesRuleException {
        Optional<Campus> campusOptional = campusRepository.findById(id);
        if(!campusOptional.isPresent()){
            BussinesRuleException exception= new BussinesRuleException("1005","Error! Campus doesn't exist", HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return convert.convertCampusDTO(campusOptional.get());
    }

    @Override
    public CampusDTO save(CampusDTO campus) {
        Optional<Users> userOptional = UsersRepository.findById(campus.getDirectorId());
        Optional<City> cityOptional = cityRepository.findById(campus.getCityId());

        if(userOptional.isPresent() && cityOptional.isPresent()){
            Campus campusEntity = convert.convertCampusEntity(campus);
            campusEntity.setDirector(userOptional.get());
            campusEntity.setCity(cityOptional.get());
            campusRepository.save(campusEntity);
            return convert.convertCampusDTO(campusEntity);
        }

        return null;
    }
    
    @Override
    public Campus update(Long id, Campus campus) {
        Optional<Campus> campusCurrentOptional = campusRepository.findById(id);

        if(campusCurrentOptional.isPresent()){
            Campus campusCurrent = campusCurrentOptional.get();
            campusCurrent.setAddress(campus.getAddress());
            campusRepository.save(campusCurrent);
            return campusCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Campus> campusOptional=campusRepository.findById(id);
        if(campusOptional.isPresent()){
            campusRepository.delete(campusOptional.get());
        }   
    }

    
}