package com.spinny.service;

import com.spinny.entity.CarActualDetails;
import com.spinny.repository.CarActualDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class CarActualDetailsService {

    private CarActualDetailsRepository carActualDetailsRepository;


    public CarActualDetailsService(CarActualDetailsRepository carActualDetailsRepository) {
        this.carActualDetailsRepository = carActualDetailsRepository;
    }

    public String uploadCarDetails(CarActualDetails carActualDetails){
       carActualDetailsRepository.save(carActualDetails);
       return "uploaded";
    }

    public String updateCarActualDetails(int actualPrice, int carActualDetailsId){
        CarActualDetails carActualDetails = carActualDetailsRepository.findById(carActualDetailsId).get();
        carActualDetails.setOfferedPrice(actualPrice);
        carActualDetails.setStatus("in progress");
        carActualDetailsRepository.save(carActualDetails);
        return "uploaded the actual price";
    }

    public String finalizedCarActualDetails(int actualPrice, int carActualDetailsId){
        CarActualDetails carActualDetails = carActualDetailsRepository.findById(carActualDetailsId).get();
        carActualDetails.setOfferedPrice(actualPrice);
        carActualDetails.setStatus("completed");
        carActualDetailsRepository.save(carActualDetails);
        return "the deal executed successfully ";
    }
}
