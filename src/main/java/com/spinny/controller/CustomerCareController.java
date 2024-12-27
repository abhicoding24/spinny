package com.spinny.controller;

import com.spinny.service.CustomerCareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customercare")
public class CustomerCareController {
    private CustomerCareService customerCareService;

    public CustomerCareController(CustomerCareService customerCareService) {
        this.customerCareService = customerCareService;
    }


    @PostMapping
    public ResponseEntity<String> allocateAgent(@RequestParam long scheduleVisitId){
        customerCareService.allocateAgent(scheduleVisitId);
        return new ResponseEntity<>("allocated", HttpStatus.CREATED);
    }
}
