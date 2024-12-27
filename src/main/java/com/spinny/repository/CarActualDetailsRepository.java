package com.spinny.repository;

import com.spinny.entity.CarActualDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarActualDetailsRepository extends JpaRepository<CarActualDetails, Integer> {
}