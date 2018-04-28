package com.pwi.controller;

import com.pwi.services.MeasurementsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/measurement")
public class MeasurementController {

    private static Logger logger = LoggerFactory.getLogger(MeasurementController.class);

    @Autowired
    MeasurementsServices measurementsServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllAvaliableMeasurements(){
        return new ResponseEntity<>(measurementsServices.getPrdMeasurmentList(), HttpStatus.OK);
    }

}
