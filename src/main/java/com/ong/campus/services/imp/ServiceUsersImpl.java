
package com.ong.campus.services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ong.campus.exceptions.BussinesRuleException;
import com.ong.campus.repositories.*;
import com.ong.campus.repositories.entities.*;
import com.ong.campus.services.*;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ServiceUsersImpl implements ServiceUsers {

    private UsersRepository usersRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Users update(Long id, Users users) {
        Optional<Users> usersCurrentOptional = usersRepository.findById(id);

        if(usersCurrentOptional.isPresent()) {
            Users usersCurrent = usersCurrentOptional.get();
            usersCurrent.setName(users.getName());
            usersRepository.save(usersCurrent);
            return usersCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<Users> usersOptional=usersRepository.findById(id);
        if(usersOptional.isPresent()) {
            usersRepository.delete(usersOptional.get());
        }   
    }

    @Override
    public Users findById(Long id) throws BussinesRuleException {
        Optional<Users> usersOptional = usersRepository.findById(id);
        if(!usersOptional.isPresent()) {
            BussinesRuleException exception= new BussinesRuleException("1001","Error! Users doesn't exist",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return usersOptional.get();
    }

}
