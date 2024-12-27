package com.spinny.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "car_evaluation")
public class CarEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "car_company_name", nullable = false)
    private String carCompanyName;

    @Column(name = "year_of_manufacturing", nullable = false)
    private Integer yearOfManufacturing;

    @Column(name = "min_driven_km", nullable = false)
    private Integer minDrivenKm;

    @Column(name = "max_driven_km", nullable = false)
    private Integer maxDrivenKm;

    @Column(name = "approx_car_amount_min", nullable = false)
    private Double approxCarAmountMin;

    @Column(name = "approx_car_value_max", nullable = false)
    private Double approxCarValueMax;

    public Double getApproxCarValueMax() {
        return approxCarValueMax;
    }

    public void setApproxCarValueMax(Double approxCarValueMax) {
        this.approxCarValueMax = approxCarValueMax;
    }

    public Double getApproxCarAmountMin() {
        return approxCarAmountMin;
    }

    public void setApproxCarAmountMin(Double approxCarAmountMin) {
        this.approxCarAmountMin = approxCarAmountMin;
    }

    public Integer getMaxDrivenKm() {
        return maxDrivenKm;
    }

    public void setMaxDrivenKm(Integer maxDrivenKm) {
        this.maxDrivenKm = maxDrivenKm;
    }

    public Integer getMinDrivenKm() {
        return minDrivenKm;
    }

    public void setMinDrivenKm(Integer minDrivenKm) {
        this.minDrivenKm = minDrivenKm;
    }

    public Integer getYearOfManufacturing() {
        return yearOfManufacturing;
    }

    public void setYearOfManufacturing(Integer yearOfManufacturing) {
        this.yearOfManufacturing = yearOfManufacturing;
    }

    public String getCarCompanyName() {
        return carCompanyName;
    }

    public void setCarCompanyName(String carCompanyName) {
        this.carCompanyName = carCompanyName;
    }
}