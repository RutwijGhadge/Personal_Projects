package org.example.ParkingLot.DTO;

import org.example.ParkingLot.Models.Constants.SupportedVehicleType;

public class TicketRequestDTO {
    private int parkingLotId;
    private int gateId;
    private String number;//vehicle number
    private String name;
    private String color;
    private SupportedVehicleType vehicleType;

    public int getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(int parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
