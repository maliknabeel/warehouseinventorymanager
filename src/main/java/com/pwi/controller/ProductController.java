package com.pwi.controller;

import com.pwi.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProducts(){
        return new ResponseEntity<>(productServices.getProductsList(), HttpStatus.OK);
    }
}
