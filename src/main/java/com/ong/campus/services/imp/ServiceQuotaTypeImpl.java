
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

public class ServiceQuotaTypeImpl implements ServiceQuotaType {

    private QuotaTypeRepository quotatypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<QuotaType> findAll() {
        return (List<QuotaType>) quotatypeRepository.findAll();
    }

    @Override
    public QuotaType save(QuotaType quotatype) {
        return quotatypeRepository.save(quotatype);
    }

    @Override
    public QuotaType update(Long id, QuotaType quotatype) {
        Optional<QuotaType> quotatypeCurrentOptional = quotatypeRepository.findById(id);

        if(quotatypeCurrentOptional.isPresent()) {
            QuotaType quotatypeCurrent = quotatypeCurrentOptional.get();
            quotatypeCurrent.setName(quotatype.getName());
            quotatypeRepository.save(quotatypeCurrent);
            return quotatypeCurrent;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        Optional<QuotaType> quotatypeOptional=quotatypeRepository.findById(id);
        if(quotatypeOptional.isPresent()) {
            quotatypeRepository.delete(quotatypeOptional.get());
        }   
    }

    @Override
    public QuotaType findById(Long id) throws BussinesRuleException {
        Optional<QuotaType> quotatypeOptional = quotatypeRepository.findById(id);
        if(!quotatypeOptional.isPresent()) {
            BussinesRuleException exception= new BussinesRuleException("1001","Error! QuotaType doesn't exist",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return quotatypeOptional.get();
    }

}
