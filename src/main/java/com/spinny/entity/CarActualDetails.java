package com.spinny.entity;

import javax.persistence.*;

@Entity
@Table(name = "car_actual_details")
public class CarActualDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "car_number", nullable = false, length = 45)
    private String carNumber;

    @Column(name = "make_year", nullable = false, length = 45)
    private String makeYear;

    @Column(name = "model", nullable = false, length = 45)
    private String model;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @Column(name = "offered_price", nullable = false, length = 45)
    private int offeredPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Agent_id", referencedColumnName = "id", nullable = false)
    private Agent agent;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(String makeYear) {
        this.makeYear = makeYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOfferedPrice() {
        return offeredPrice;
    }

    public void setOfferedPrice(int offeredPrice) {
        this.offeredPrice = offeredPrice;
    }


    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}