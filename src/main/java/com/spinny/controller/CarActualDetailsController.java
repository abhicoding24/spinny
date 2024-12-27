package com.spinny.controller;

import com.spinny.entity.CarActualDetails;
import com.spinny.service.CarActualDetailsService;
import org.apache.commons.collections4.Put;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car_details")
public class CarActualDetailsController {
    private CarActualDetailsService carActualDetailsService;

    public CarActualDetailsController(CarActualDetailsService carActualDetailsService) {
        this.carActualDetailsService = carActualDetailsService;
    }

    //below url should be accessed by agent
    @PostMapping("/upload")
    public ResponseEntity<String> uploadCarDetails(@RequestBody CarActualDetails carActualDetails){
        String msg = carActualDetailsService.uploadCarDetails(carActualDetails);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    //below url should be accessed by evaluation team
    @PutMapping("/actualPrice")
    public ResponseEntity<String> updateCarActualDetails(@RequestParam int actualPrice, @RequestParam int carActualDetailsId){
        String msg = carActualDetailsService.updateCarActualDetails(actualPrice, carActualDetailsId);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    //below url should be accessed by evaluation team, this will work only when the customer agreed with the price set by evaluation team
    //accessed only after clearing the payment & receiving the car
    @PutMapping("/finalizedPrice")
    public ResponseEntity<String> finalizedCarActualDetails(@RequestParam int actualPrice, @RequestParam int carActualDetailsId){
        String msg = carActualDetailsService.finalizedCarActualDetails(actualPrice, carActualDetailsId);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}

