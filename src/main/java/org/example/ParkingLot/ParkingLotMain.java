package org.example.ParkingLot;

import org.example.ParkingLot.Exception.ParkingLotNotFoundException;
import org.example.ParkingLot.Models.ParkingLot;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.ParkingFloorRepository;
import org.example.ParkingLot.Repository.ParkingLotRepository;
import org.example.ParkingLot.Repository.ParkingSlotRepository;
import org.example.ParkingLot.Service.initService;
import org.example.ParkingLot.Service.initServiceIMPL;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException {
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository=new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository=new ParkingSlotRepository();
        GateRepository gateRepository=new GateRepository();

        initService initservice=new initServiceIMPL(gateRepository,parkingFloorRepository,parkingLotRepository,
                parkingSlotRepository);
        initservice.run();
        ParkingLot parkingLot=parkingLotRepository.get(1);


    }
}
