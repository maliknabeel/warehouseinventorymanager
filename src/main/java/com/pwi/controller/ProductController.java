package com.pwi.controller;

import com.pwi.entities.ProductsEntity;
import com.pwi.services.MeasurementsServices;
import com.pwi.services.ProductServices;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addNewProduct(@RequestBody ProductsEntity productsEntity){
        logger.info("Adding a new product");
        return new ResponseEntity<>(productServices.createOrUpdateProducts(productsEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> removeAProduct(@RequestBody ProductsEntity productsEntity){
        logger.info("Removing a product");
        productServices.deletePProduct(productsEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Product Deleted"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAProduct(@RequestBody ProductsEntity productsEntity){
        logger.info("Updating an existing product");
        return new ResponseEntity<>(productServices.createOrUpdateProducts(productsEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Object> findProductById(@PathVariable int productId){
        logger.info("Get a particular product by id :: " + productId);
        return new ResponseEntity<>(productServices.getProductById(productId), HttpStatus.OK);
    }
}
