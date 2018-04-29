package com.pwi.controller;

import com.pwi.entities.ProductPkgingEntity;
import com.pwi.services.ProductPkgingServices;
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
@RequestMapping("/packaging")
public class ProductPackagingController {

    @Autowired
    ProductPkgingServices productPkgingServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllPackagingDetails(){
        return new ResponseEntity<>(productPkgingServices.getProductsPkgingList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addPackagingDetails(@RequestBody ProductPkgingEntity productPkgingEntity){
        return new ResponseEntity<>(productPkgingServices.createOrUpdateProductsPkging(productPkgingEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> upadtePackagingDetails(@RequestBody ProductPkgingEntity productPkgingEntity){
        return new ResponseEntity<>(productPkgingServices.createOrUpdateProductsPkging(productPkgingEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object>deletePackagingDetails(@RequestBody ProductPkgingEntity productPkgingEntity){
        productPkgingServices.deleteProductsPkging(productPkgingEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Deletion Successful"), HttpStatus.OK);
    }
}
