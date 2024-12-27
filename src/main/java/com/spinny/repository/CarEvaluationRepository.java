package com.spinny.repository;

import com.spinny.entity.CarEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarEvaluationRepository extends JpaRepository<CarEvaluation, Long> {
    @Query("SELECT c from CarEvaluation c WHERE c.yearOfManufacturing = :yearOfManufacturing "+" AND c.minDrivenKm <= :maxDrivenKm And c.maxDrivenKm >= :minDrivenKm")
    List<CarEvaluation> findCarByYearAndKmRange(@Param("yearOfManufacturing") int yearOfManufacturing,
                                                @Param("minDrivenKm") int minDrivenKm,
                                                @Param("maxDrivenKm") int maxDrivenKm);
}
