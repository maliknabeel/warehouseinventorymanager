package com.pwi.controller;

import com.pwi.services.MeasurementsServices;
import com.pwi.services.ProductServices;
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
@RequestMapping("/product")
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(MeasurementController.class);

    @Autowired
    ProductServices productServices;

    @Autowired
    MeasurementsServices measurementsServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProducts(){
        return new ResponseEntity<>(productServices.getProductsList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{productId}/measurements", method = RequestMethod.GET)
    public ResponseEntity<Object> getProductsForAMeasurements(@PathVariable int productId){
        logger.info("Measurement ID ::" + productId);
        return new ResponseEntity<>(measurementsServices.getMeasurementsForAProduct(productId), HttpStatus.OK);
    }
}
