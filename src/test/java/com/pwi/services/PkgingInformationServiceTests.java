package com.pwi.services;

import com.pwi.entities.PkgingInformationEntity;
import com.pwi.repositories.IPkgingInformationRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class PkgingInformationServiceTests {

    @Mock
    IPkgingInformationRepository pkgingInformationRepository;

    @InjectMocks
    PkgingInformationServices pkgingInformationServices;

    @Spy
    private List<PkgingInformationEntity> pkgingInformationList = new ArrayList<>();

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        initPkgingInformationList();
    }

    @Test
    public void listAllPkgingInformation() {
        when(pkgingInformationRepository.findAll()).thenReturn(pkgingInformationList);
        List<PkgingInformationEntity> pkgingInformationListMock = pkgingInformationServices.getPkgingInformationList();
        assertThat(pkgingInformationListMock).isEqualTo(pkgingInformationList);
    }

    @Test
    public void createPkgingInformation() {
        PkgingInformationEntity pkgingInformationEntity = pkgingInformationList.get(1);
        pkgingInformationServices.createOrUpdatePkgingInformation(pkgingInformationEntity);
        verify(pkgingInformationRepository, atLeastOnce()).save(pkgingInformationEntity);
    }

    private void initPkgingInformationList() {
        PkgingInformationEntity pkgingInformationEntity;

        pkgingInformationEntity = new PkgingInformationEntity();
        pkgingInformationEntity.setIdPkgingInfo(5);
        pkgingInformationEntity.setPkgingSize(12);
        pkgingInformationEntity.setPkgingUnit("pcs");
        pkgingInformationList.add(pkgingInformationEntity);

        pkgingInformationEntity = new PkgingInformationEntity();
        pkgingInformationEntity.setIdPkgingInfo(6);
        pkgingInformationEntity.setPkgingSize(24);
        pkgingInformationEntity.setPkgingUnit("pcs");
        pkgingInformationList.add(pkgingInformationEntity);
    }
}
