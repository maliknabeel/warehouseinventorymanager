package com.pwi.controller;

import com.pwi.services.InventoryCustomReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/country")
public class CountryController {

    private static Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private InventoryCustomReportService inventoryCustomReportService;


    @RequestMapping(value = "/{cid}/inventory", method = RequestMethod.GET)
    public ResponseEntity<Object> getInventoryDetails(@PathVariable int cid){
        logger.info("The value for country ID :: " + cid);
        return new ResponseEntity<>(inventoryCustomReportService.getInventoryReportByCountryId(cid), HttpStatus.OK);
    }
}
