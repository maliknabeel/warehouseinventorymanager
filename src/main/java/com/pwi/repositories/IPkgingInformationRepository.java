package com.pwi.repositories;

import com.pwi.entities.PkgingInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPkgingInformationRepository extends JpaRepository<PkgingInformationEntity, Integer> {
}
