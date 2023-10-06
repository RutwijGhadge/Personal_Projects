package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.ParkingLotStatus;
import org.example.ParkingLot.Models.Constants.VehicleType;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloor;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType>allowedvehicleTypes;
    private SlotAllocationStrategy slotAllocationStrategy;
    private BillCalculationStartegy billCalculationStartegy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ParkingFloor> getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(List<ParkingFloor> parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getAllowedvehicleTypes() {
        return allowedvehicleTypes;
    }

    public void setAllowedvehicleTypes(List<VehicleType> allowedvehicleTypes) {
        this.allowedvehicleTypes = allowedvehicleTypes;
    }

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public BillCalculationStartegy getBillCalculationStartegy() {
        return billCalculationStartegy;
    }

    public void setBillCalculationStartegy(BillCalculationStartegy billCalculationStartegy) {
        this.billCalculationStartegy = billCalculationStartegy;
    }
}
