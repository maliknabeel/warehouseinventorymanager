package com.pwi.services;

import com.pwi.entities.PkgingInformationEntity;
import com.pwi.repositories.IPkgingInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PkgingInformationServices {

    @Autowired
    IPkgingInformationRepository pkgingInformationRepository;

    public List<PkgingInformationEntity> getPkgingInformationList() {
        return pkgingInformationRepository.findAll();
    }

    public PkgingInformationEntity getPkgingInformationById(int pkgingInformationId) {
        return pkgingInformationRepository.findById(pkgingInformationId).orElseThrow(() -> new RuntimeException("Packaging Information ID not found"));
    }

    public PkgingInformationEntity createOrUpdatePkgingInformation(PkgingInformationEntity pkgingInformationEntity) {
        return pkgingInformationRepository.save(pkgingInformationEntity);
    }

    public void deletePkgingInformation(PkgingInformationEntity pkgingInformationEntity) {
        pkgingInformationRepository.delete(pkgingInformationEntity);
    }
}
