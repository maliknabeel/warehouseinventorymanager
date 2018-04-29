package com.pwi.controller;

import com.pwi.entities.PkgingInformationEntity;
import com.pwi.services.PkgingInformationServices;
import com.pwi.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */
@Controller
@RequestMapping("productpackaging")
public class PkgingInformationController {

    @Autowired
    PkgingInformationServices pkgingInformationServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllPkgingInformation(){
        return new ResponseEntity<>(pkgingInformationServices.getPkgingInformationList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addNewPkgingInformation(@RequestBody PkgingInformationEntity pkgingInformationEntity){
        return new ResponseEntity<>(pkgingInformationServices.createOrUpdatePkgingInformation(pkgingInformationEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePkgingInformation(@RequestBody PkgingInformationEntity pkgingInformationEntity){
        return new ResponseEntity<>(pkgingInformationServices.createOrUpdatePkgingInformation(pkgingInformationEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePkgingInformation(@RequestBody PkgingInformationEntity pkgingInformationEntity){
        pkgingInformationServices.deletePkgingInformation(pkgingInformationEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Deletion Successful"), HttpStatus.OK);
    }
}
