package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Exception.ParkingSlotNotFoundException;
import org.example.ParkingLot.Models.ParkingSlot;
import org.example.ParkingLot.Models.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepository {
    private HashMap<Integer, ParkingSlot> ParkingSlotMap=new HashMap<Integer, ParkingSlot>();

    public ParkingSlotRepository(HashMap<Integer, ParkingSlot> parkingSlotMap) {
        this.ParkingSlotMap = new HashMap<>();
    }

    public ParkingSlot get(int parkingSlotId) throws ParkingSlotNotFoundException {
        ParkingSlot parkingSlot=ParkingSlotMap.get(parkingSlotId);//getting parkingSlot from the hashmap-> if null then throw exception else return the parkingSlot
        if(parkingSlot==null)
            throw new ParkingSlotNotFoundException("ParkingSlot Not present with Id"+parkingSlotId);
        return parkingSlot;
    }

    public ParkingSlot put(ParkingSlot parkingSlot){
        ParkingSlotMap.put(parkingSlot.getId(),parkingSlot); //inserting the parkingSlot in the map
        return parkingSlot;
    }
}
