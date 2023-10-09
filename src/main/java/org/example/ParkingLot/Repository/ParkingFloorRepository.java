package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Exception.ParkingFloorNotFoundException;
import org.example.ParkingLot.Models.ParkingFloor;

import java.util.HashMap;

public class ParkingFloorRepository {
    private HashMap<Integer, ParkingFloor> ParkingFloorMap=new HashMap<Integer, ParkingFloor>();

    public ParkingFloorRepository(HashMap<Integer, ParkingFloor> parkingFloorMap) {
        this.ParkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorId) throws ParkingFloorNotFoundException {
        ParkingFloor parkingFloor=ParkingFloorMap.get(parkingFloorId);//getting parkingFloor from the hashmap-> if null then throw exception else return the parkingFloor
        if(parkingFloor==null)
            throw new ParkingFloorNotFoundException("ParkingFloor Not present with Id"+parkingFloorId);
        return parkingFloor;
    }

    public ParkingFloor put(ParkingFloor parkingFloor){
        ParkingFloorMap.put(parkingFloor.getId(),parkingFloor); //inserting the parkingFloor in the map
        return parkingFloor;
    }
}
