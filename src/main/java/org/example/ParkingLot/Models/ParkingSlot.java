package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.ParkingSlotStatus;
import org.example.ParkingLot.Models.Constants.SupportedVehicleType;

public class ParkingSlot extends BaseModel{
    private int id;
    private int slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private SupportedVehicleType supportedVehicleType;
    private Vehicle vehicle;        //storing the info of vehicle

    public ParkingSlot() {
    }

    public ParkingSlot( int id,int slotNumber,
                        SupportedVehicleType supportedVehicleType) {
        super((id));
        this.slotNumber = slotNumber;
        this.parkingSlotStatus = ParkingSlotStatus.AVAILABLE;
        this.supportedVehicleType = supportedVehicleType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public SupportedVehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(SupportedVehicleType supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
