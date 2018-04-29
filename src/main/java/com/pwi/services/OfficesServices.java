package com.pwi.services;

import com.pwi.entities.OfficesEntity;
import com.pwi.repositories.IOfficesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */

@Service
public class OfficesServices {

    @Autowired
    IOfficesRepository officesRepository;

    public List<OfficesEntity> getOfficesList() {
        return officesRepository.findAll();
    }

    public OfficesEntity getOfficeById(int officeId) {
        return officesRepository.findById(officeId).orElseThrow(() -> new RuntimeException("Office ID not found"));
    }

    public OfficesEntity createOrUpdateOffice(OfficesEntity officesEntity) {
        return officesRepository.save(officesEntity);
    }

    public void deleteOffice(OfficesEntity officesEntity) {
        officesRepository.delete(officesEntity);
    }
}
