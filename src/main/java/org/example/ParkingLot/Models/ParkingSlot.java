package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.ParkingSlotStatus;
import org.example.ParkingLot.Models.Constants.VehicleType;

public class ParkingSlot extends BaseModel{
    private int slotNumber;
    private ParkingSlotStatus parkingSlotStatus;
    private VehicleType vehicleType;
    private Vehicle vehicle;        //storing the info of vehicle


}
