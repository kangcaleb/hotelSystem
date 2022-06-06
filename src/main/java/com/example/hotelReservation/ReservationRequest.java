package com.example.hotelReservation;

import java.util.Date;

public class ReservationRequest {
    private String name;
    private String phoneNumber;
    private String arrivalDate;
    private Integer numNights;


    public ReservationRequest(String name, String phoneNumber, String arrivalDate, Integer numNights) {
        this.name=name; this.phoneNumber=phoneNumber;
        this.arrivalDate=arrivalDate; this.numNights=numNights;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Integer getNumNights() {
        return numNights;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getName() {
        return name;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumNights(Integer numNights) {
        this.numNights = numNights;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}


