package org.parking.parkinglot.common;

import org.parking.parkinglot.entities.Car;

public class CarDto {
    private Long id;
    private String licensePlate;
    private String parkingSpot;
    private  String ownerName;


    public CarDto(Long id, String licensePlate, String parkingSpot, String ownerName) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.parkingSpot = parkingSpot;
        this.ownerName = ownerName;
    }

    public CarDto(Car car)
    {
        this.id = car.getId();
        this.licensePlate = car.getLicensePlate();
        this.parkingSpot = car.getParkingSpot();
        this.ownerName = car.getOwner().getUsername();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
