package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Exception.BillNotFoundException;
import org.example.ParkingLot.Models.Bill;

import java.util.HashMap;

public class BillRepository {
    public BillRepository() {
    }

    private HashMap<Integer, Bill> BillMap=new HashMap<Integer, Bill>();

    public BillRepository(HashMap<Integer, Bill> BillMap) {
        this.BillMap = new HashMap<>();
    }

    public Bill get(int BillId) throws BillNotFoundException {
        Bill Bill=BillMap.get(BillId);//getting Bill from the hashmap-> if null then throw exception else return the Bill
        if(Bill==null)
            throw new BillNotFoundException("Bill Not present with Id"+BillId);
        return Bill;
    }

    public Bill put(Bill Bill){
        BillMap.put(Bill.getId(),Bill); //inserting the Bill in the map
        return Bill;
    }
}
