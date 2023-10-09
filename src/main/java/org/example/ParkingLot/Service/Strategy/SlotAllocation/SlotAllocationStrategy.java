package org.example.ParkingLot.Service.Strategy.SlotAllocation;

import org.example.ParkingLot.Models.Constants.VehicleType;
import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.ParkingLot;
import org.example.ParkingLot.Models.ParkingSlot;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot,  Gate EntryGate );
    //vehicleType and ParkingLot Require
}
