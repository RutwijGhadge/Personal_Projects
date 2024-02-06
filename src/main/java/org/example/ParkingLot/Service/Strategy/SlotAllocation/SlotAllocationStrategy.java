package org.example.ParkingLot.Service.Strategy.SlotAllocation;

import org.example.ParkingLot.Exception.ParkingSlotNotAvailable;
import org.example.ParkingLot.Models.Constants.SupportedVehicleType;
import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.ParkingLot;
import org.example.ParkingLot.Models.ParkingSlot;

public interface SlotAllocationStrategy {
    ParkingSlot findParkingSlot(SupportedVehicleType vehicleType, ParkingLot parkingLot, Gate EntryGate ) throws ParkingSlotNotAvailable;
    //vehicleType and ParkingLot Require
    //entry gate require for nearest slot allocation
}
