package com.pwi.controller;

import com.pwi.entities.MeasurementEntity;
import com.pwi.services.MeasurementsServices;
import com.pwi.utils.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/measurement")
public class MeasurementController {

    private static Logger logger = LoggerFactory.getLogger(MeasurementController.class);

    @Autowired
    MeasurementsServices measurementsServices;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllAvaliableMeasurements(){
        return new ResponseEntity<>(measurementsServices.getPrdMeasurmentList(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> addMeasurements(@RequestBody MeasurementEntity measurementEntity){
        return new ResponseEntity<>(measurementsServices.createOrUpdatePrdMeasurement(measurementEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMeasurements(@RequestBody MeasurementEntity measurementEntity){
        return new ResponseEntity<>(measurementsServices.createOrUpdatePrdMeasurement(measurementEntity), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteMeasurements(@RequestBody MeasurementEntity measurementEntity){
        measurementsServices.deletePrdMeasurement(measurementEntity);
        return new ResponseEntity<>(new ResponseBody(true, "Successfully Deleted"), HttpStatus.OK);
    }
}
