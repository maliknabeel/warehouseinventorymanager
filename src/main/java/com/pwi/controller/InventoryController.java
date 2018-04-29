package com.pwi.controller;

import com.pwi.entities.InventoryEntity;
import com.pwi.services.InventoryCustomReportService;
import com.pwi.services.InventoryServices;
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
@RequestMapping("/inventory")
public class InventoryController {

    public Logger logger =  LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    InventoryServices inventoryServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getCompleteInventoryList(){
        return new ResponseEntity<>(inventoryServices.getInventoryList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addInventory(@RequestBody InventoryEntity inventoryEntity){
        return new ResponseEntity<>(inventoryServices.createOrUpdateInventory(inventoryEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateInventory(@RequestBody InventoryEntity inventoryEntity){
        return new ResponseEntity<>(inventoryServices.createOrUpdateInventory(inventoryEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteInventory(@RequestBody InventoryEntity inventoryEntity){
        inventoryServices.deleteInventory(inventoryEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Inventory deleted successfullt"), HttpStatus.OK);
    }
}
