package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Models.Gate;

import java.util.HashMap;

public class GateRepository {
    public GateRepository() {
    }
    //HashMaps will Acts as a Database for this Project
    //put the data or insert the data in HashMaps or Receive the data from Hashmap
    //Like Database CRUD operation

    private HashMap<Integer, Gate>gateMap=new HashMap<Integer, Gate>();
    //it will contain the GateId -> Gate

    public GateRepository(HashMap<Integer, Gate> gateMap) {//Constructor
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId) throws GateNotFoundException {
        Gate gate=gateMap.get(gateId);
        //getting gate from the hashmap-> if null then throw exception else return the gate
        if(gate==null)
            throw new GateNotFoundException("Gate Not present with Id"+gateId);
        return gate;
    }

    public Gate put(Gate gate){
        gateMap.put(gate.getId(),gate); //inserting the gate in the map
        return gate;
    }
}
