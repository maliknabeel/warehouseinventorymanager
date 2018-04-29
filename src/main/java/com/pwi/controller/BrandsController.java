package com.pwi.controller;

import com.pwi.entities.BrandsEntity;
import com.pwi.services.BrandsServices;
import com.pwi.utils.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("brands")
public class BrandsController {

    @Autowired
    BrandsServices brandsServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBrands(){
        return new ResponseEntity<>(brandsServices.getBrandsList(), HttpStatus.OK);
    }

    @RequestMapping(value = "{brandId}",method = RequestMethod.GET)
    public ResponseEntity<Object> getBrandsByID(@PathVariable int brandId){
        return new ResponseEntity<>(brandsServices.getBrandById(brandId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addNewBrand(@RequestBody BrandsEntity brandsEntity){
        return new ResponseEntity<>(brandsServices.createOrUpdateBrand(brandsEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBrand(@RequestBody BrandsEntity brandsEntity){
        return new ResponseEntity<>(brandsServices.createOrUpdateBrand(brandsEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteBrand(@RequestBody BrandsEntity brandsEntity){
        brandsServices.deleteBrand(brandsEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Deletion Successful"), HttpStatus.OK);
    }
}
