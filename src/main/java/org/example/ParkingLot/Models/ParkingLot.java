package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.ParkingLotStatus;
import org.example.ParkingLot.Models.Constants.SupportedVehicleType;
import org.example.ParkingLot.Service.Strategy.BillCalculation.BillCalculationStrategy;
import org.example.ParkingLot.Service.Strategy.SlotAllocation.SlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel{
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloor;
    private ParkingLotStatus parkingLotStatus;
    private List<SupportedVehicleType>allowedvehicleTypes;
    private SlotAllocationStrategy slotAllocationStrategy;
    private BillCalculationStrategy billCalculationStrategy;

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

    public List<SupportedVehicleType> getAllowedvehicleTypes() {
        return allowedvehicleTypes;
    }

    public void setAllowedvehicleTypes(List<SupportedVehicleType> allowedvehicleTypes) {
        this.allowedvehicleTypes = allowedvehicleTypes;
    }

    public SlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public void setSlotAllocationStrategy(SlotAllocationStrategy slotAllocationStrategy) {
        this.slotAllocationStrategy = slotAllocationStrategy;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStartegy(BillCalculationStrategy billCalculationStartegy) {
        this.billCalculationStrategy = billCalculationStartegy;
    }
}
