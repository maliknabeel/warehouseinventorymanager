package com.pwi.controller;

import com.pwi.entities.BrandProductTypeEntity;
import com.pwi.services.BrandProductTypeServices;
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
@RequestMapping("type")
public class BrandProductTypeController {

    @Autowired
    BrandProductTypeServices brandProductTypeServices;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBrandProductTypes(){
        return new ResponseEntity<>(brandProductTypeServices.getProductsTypeList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createBrandProductTypes(@RequestBody BrandProductTypeEntity brandProductTypeEntity){
        return new ResponseEntity<>(brandProductTypeServices.createOrUpdateProductsType(brandProductTypeEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBrandProductTypes(@RequestBody BrandProductTypeEntity brandProductTypeEntity){
        return new ResponseEntity<>(brandProductTypeServices.createOrUpdateProductsType(brandProductTypeEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBrandProductTypes(@RequestBody BrandProductTypeEntity brandProductTypeEntity){
        brandProductTypeServices.deleteProductsType(brandProductTypeEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Deletion Successful"), HttpStatus.OK);
    }
}
