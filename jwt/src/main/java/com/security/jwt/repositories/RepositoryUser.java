package com.security.jwt.repositories;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.security.jwt.repositories.entities.UserEntity;

public interface RepositoryUser extends CrudRepository<UserEntity,BigInteger> {

    Optional<UserEntity> findByEmail(String email);
    
}
