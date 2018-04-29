package com.pwi.controller;

import com.pwi.entities.WarehouseEntity;
import com.pwi.services.WarehouseServices;
import com.pwi.utils.ResponseBody;
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
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseServices warehouseServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllWarehouseDetails(){
        return new ResponseEntity<>(warehouseServices.getWarehouseList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{warehouseId}" ,method = RequestMethod.GET)
    public ResponseEntity<Object> getDetailsOfAWarehouse(@PathVariable int warehouseId){
        return new ResponseEntity<>(warehouseServices.getWarehouseById(warehouseId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addAWarehouse(@RequestBody WarehouseEntity warehouseEntity){
        return new ResponseEntity<>(warehouseServices.createOrUpdateWarehouse(warehouseEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAWarehouse(@RequestBody WarehouseEntity warehouseEntity){
        return new ResponseEntity<>(warehouseServices.createOrUpdateWarehouse(warehouseEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAWarehouse(@RequestBody WarehouseEntity warehouseEntity){
        warehouseServices.deleteWarehouse(warehouseEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Successfully Deleted"), HttpStatus.OK);
    }
}
