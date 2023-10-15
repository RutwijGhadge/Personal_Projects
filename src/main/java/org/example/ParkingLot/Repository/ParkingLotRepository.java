package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Exception.ParkingLotNotFoundException;
import org.example.ParkingLot.Models.ParkingLot;

import java.util.HashMap;

public class ParkingLotRepository {
    private HashMap<Integer, ParkingLot> ParkingLotMap=new HashMap<Integer, ParkingLot>();

    public ParkingLotRepository() {
        this.ParkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId) throws ParkingLotNotFoundException {
        ParkingLot parkingLot=ParkingLotMap.get(parkingLotId);//getting parkingLot from the hashmap-> if null then throw exception else return the parkingLot
        if(parkingLot==null)
            throw new ParkingLotNotFoundException("ParkingLot Not present with Id"+parkingLotId);
        return parkingLot;
    }

    public ParkingLot put(ParkingLot parkingLot){
        ParkingLotMap.put(parkingLot.getId(),parkingLot); //inserting the parkingLot in the map
        return parkingLot;
    }
}
