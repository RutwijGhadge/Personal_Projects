package org.example.ParkingLot.Service.Strategy.SlotAllocation;

import org.example.ParkingLot.Exception.ParkingSlotNotAvailable;
import org.example.ParkingLot.Models.Constants.ParkingSlotStatus;
import org.example.ParkingLot.Models.Constants.SupportedVehicleType;
import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.ParkingLot;
import org.example.ParkingLot.Models.ParkingSlot;

public class NearestSlotAllocationStrategy implements SlotAllocationStrategy{

    private ParkingSlot AllocateSlot(SupportedVehicleType vehicleType,ParkingLot parkingLot,Gate EntryGate,int floorNumber){
        floorNumber=EntryGate.getFloornumber();// floor from which the vehicle enters
        //iterating on the slots present in the Floor
        for(ParkingSlot slot : parkingLot.getParkingFloor().get(floorNumber).getParkingSlot() ) {
            if (slot.getSupportedVehicleType().equals(vehicleType) &&
                    slot.getParkingSlotStatus().equals(ParkingSlotStatus.AVAILABLE)) {
                slot.setParkingSlotStatus(ParkingSlotStatus.NOTAVAILABLE);//making the slot status FULL once allocated
                return slot;//Allocate the slot which met the above conditions
            }
        }
        return null;
    }

    @Override
    public ParkingSlot findParkingSlot(SupportedVehicleType vehicleType, ParkingLot parkingLot, Gate EntryGate) throws ParkingSlotNotAvailable {
        int floorNumber = EntryGate.getFloornumber();
        ParkingSlot slot=AllocateSlot(vehicleType,parkingLot,EntryGate,floorNumber);
        if(slot!=null)
            return slot;

        int i = floorNumber - 1;
        int j = floorNumber + 1;//either upper floor or the lower floor
        while (i >= 0 || j < parkingLot.getParkingFloor().size()) {
            if (i >= 0) {
                slot=AllocateSlot(vehicleType, parkingLot, EntryGate, i);
                if(slot!=null)
                    return slot;
            }
            if(j < parkingLot.getParkingFloor().size()) {
               slot= AllocateSlot(vehicleType, parkingLot, EntryGate, j);
                if(slot!=null)
                    return slot;
            }
            i--;
            j++;
        }
        throw new ParkingSlotNotAvailable("No Parking Slot Available for your vehicle, Please try after some time");//not found
    }
}
