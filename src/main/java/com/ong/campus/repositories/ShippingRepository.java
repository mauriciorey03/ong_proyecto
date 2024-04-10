package com.ong.campus.repositories;

import org.springframework.data.repository.CrudRepository;
import com.ong.campus.repositories.entities.*;
import java.util.List;



public interface ShippingRepository extends CrudRepository<Shipping, Long> {
    List<Shipping> findByFinished(boolean finished);
    List<Shipping> findByCampusesId(Long campusId);

}