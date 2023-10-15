package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private int floorNumber;
    private String address;
    private List<ParkingSlot> parkingSlot;
    private List<Gate>gate;
    private ParkingFloorStatus parkingFloorStatus;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingSlot> getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(List<ParkingSlot> parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public List<Gate> getGate() {
        return gate;
    }

    public void setGate(List<Gate> game) {
        this.gate = gate;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
