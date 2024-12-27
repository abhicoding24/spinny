package com.spinny.controller;


import com.spinny.entity.CarEvaluation;
import com.spinny.service.CarEvaluationUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/car-evaluations")
public class CarEvaluationController {

    @Autowired
    private CarEvaluationUploadService carEvaluationUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCarEvaluations(@RequestParam("file") MultipartFile file) {
        try {
            carEvaluationUploadService.uploadExcel(file);
            return new ResponseEntity<>("Car evaluations uploaded successfully!", HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Failed to upload file: " + e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-evaluation")
    public ResponseEntity<List<CarEvaluation>> getEstimation(@RequestParam int yearOfManufacturing, @RequestParam int maxDrivenKm, @RequestParam int minDrivenKm){
        List<CarEvaluation> carEvaluation = carEvaluationUploadService.getEstimation(yearOfManufacturing, maxDrivenKm, minDrivenKm);
        return new ResponseEntity<>(carEvaluation,HttpStatus.OK);
    }
}