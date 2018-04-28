package com.pwi.controller;

import com.pwi.services.InventoryCustomReportService;
import com.pwi.services.InventoryServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private static Logger logger = LogManager.getLogger();

    @Autowired
    InventoryServices inventoryServices;

    @Autowired
    InventoryCustomReportService inventoryCustomReportService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getCompleteInventoryList(){
        return new ResponseEntity<>(inventoryServices.getInventoryList(), HttpStatus.OK);
    }

    @RequestMapping(value = "{cid}", method = RequestMethod.GET)
    public ResponseEntity<Object> getInventoryDetails(@PathVariable int cid){
        logger.info("The value for country id is" + cid);
        return new ResponseEntity<>(inventoryCustomReportService.getInventoryReportByCountryId(cid), HttpStatus.OK);
    }
}
