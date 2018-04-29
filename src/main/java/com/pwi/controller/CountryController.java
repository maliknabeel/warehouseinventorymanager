package com.pwi.controller;

import com.pwi.entities.CountryEntity;
import com.pwi.services.CountryServices;
import com.pwi.services.InventoryCustomReportService;
import com.pwi.utils.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nabeel Ahmed
 * @version 1.0
 */
@Controller
@RequestMapping("/country")
public class CountryController {

    private static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private InventoryCustomReportService inventoryCustomReportService;

    @Autowired
    CountryServices countryServices;


    @RequestMapping(value = "/{cid}/inventory", method = RequestMethod.GET)
    public ResponseEntity<Object> getInventoryDetails(@PathVariable int cid){
        logger.info("The value for country ID :: " + cid);
        return new ResponseEntity<>(inventoryCustomReportService.getInventoryReportByCountryId(cid), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getCountryList(){
        return new ResponseEntity<>(countryServices.getCountriesList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{countryId}",method = RequestMethod.GET)
    public ResponseEntity<Object> getCountryById(@PathVariable int countryId){
        logger.info("The value for country ID :: " + countryId);
        return new ResponseEntity<>(countryServices.getCountryById(countryId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addCountry(@RequestBody CountryEntity countryEntity){
        return new ResponseEntity<>(countryServices.createOrUpdateCountry(countryEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> uodateCountry(@RequestBody CountryEntity countryEntity){
        return new ResponseEntity<>(countryServices.createOrUpdateCountry(countryEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteCountry(@RequestBody CountryEntity countryEntity){
        countryServices.deleteCountry(countryEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Deletion Successful"), HttpStatus.OK);
    }
}
