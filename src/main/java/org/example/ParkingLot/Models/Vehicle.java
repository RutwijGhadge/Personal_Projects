package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.SupportedVehicleType;

public class Vehicle extends BaseModel{
    private String VehicleNumber;
    private String name;
    private String color;
    private SupportedVehicleType vehicleType;

    public Vehicle(String vehicleNumber, String name, String color, SupportedVehicleType vehicleType) {
        VehicleNumber = vehicleNumber;
        this.name = name;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public SupportedVehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(SupportedVehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
