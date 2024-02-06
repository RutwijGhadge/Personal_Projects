package org.example.ParkingLot.Service;

import org.example.ParkingLot.Models.Constants.*;
import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.ParkingFloor;
import org.example.ParkingLot.Models.ParkingLot;
import org.example.ParkingLot.Models.ParkingSlot;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.ParkingFloorRepository;
import org.example.ParkingLot.Repository.ParkingLotRepository;
import org.example.ParkingLot.Repository.ParkingSlotRepository;
import org.example.ParkingLot.Service.Strategy.BillCalculation.BillCalculationStrategyFactory;
import org.example.ParkingLot.Service.Strategy.SlotAllocation.SlotAllocationStrategyFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class initServiceIMPL implements initService {
    //this class is used for initialization
    private GateRepository gateRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingSlotRepository parkingSlotRepository;
    public initServiceIMPL(GateRepository gateRepository, ParkingFloorRepository parkingFloorRepository,
                           ParkingLotRepository parkingLotRepository, ParkingSlotRepository parkingSlotRepository) {
        this.gateRepository = gateRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @Override
    public void run() {
        ParkingLot parkingLot=new ParkingLot();
        //setting attributes for ParkingFloor
        parkingLot.setId(1);
        parkingLot.setName("Mahatma Gandhi Parking ");
        parkingLot.setAddress("Pune");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setAllowedvehicleTypes(new ArrayList<>(Arrays.asList(SupportedVehicleType.BUS,
                SupportedVehicleType.BIKE,SupportedVehicleType.CAR)));
        parkingLot.setSlotAllocationStrategy(SlotAllocationStrategyFactory.getSlotAllocationStrategy());
        parkingLot.setBillCalculationStartegy(BillCalculationStrategyFactory.getBillCalculationStrategy());

        List<ParkingFloor>parkingFloors=new ArrayList<>();
        for(int i=0;i<10;i++){
            //10 Floors of Parking
            ParkingFloor parkingFloor=new ParkingFloor();//new floor object
            parkingFloor.setFloorNumber(i+1);
            List<ParkingSlot>parkingSlots=new ArrayList<>();//ParkingSlots per floor
            for(int j=1;j<=10;j++) {
                SupportedVehicleType supportedVehicleType= j % 2 == 0 ? SupportedVehicleType.CAR :
                        SupportedVehicleType.BIKE;        //alternate CAR and Bike Parking
                ParkingSlot parkingSlot = new ParkingSlot(i * 100 + j,i * 100 + j,
                        supportedVehicleType );
                parkingSlots.add(parkingSlot);
                parkingSlotRepository.put(parkingSlot);
            }

            parkingFloor.setParkingSlot(parkingSlots);//assigning ParkingSlots to respective ParkingFloor
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.OPEN);

            Gate EntryGate=new Gate();
            EntryGate.setId(i*10+1);
            EntryGate.setGatenumber(i*10+1);
            EntryGate.setGateStatus(GateStatus.OPEN);
            EntryGate.setGateType(GateType.ENTRY);
            EntryGate.setOperator("Bhavani");
            EntryGate.setParkinglotid(1);
            EntryGate.setFloornumber(i);
            gateRepository.put(EntryGate);

            Gate ExitGate=new Gate();
            ExitGate.setId(i*10+2);
            ExitGate.setGatenumber(i*10+2);
            ExitGate.setGateStatus(GateStatus.OPEN);
            ExitGate.setGateType(GateType.EXIT);
            ExitGate.setOperator("Sushil");
            ExitGate.setParkinglotid(1);
            ExitGate.setFloornumber(i);
            gateRepository.put(ExitGate);

            List<Gate>gates=new ArrayList<>(Arrays.asList(EntryGate,ExitGate));
            parkingFloor.setGate(gates);
            parkingFloors.add(parkingFloor);    //adding floor
            parkingFloorRepository.put(parkingFloor);

        }
        parkingLot.setParkingFloor(parkingFloors);
        parkingLotRepository.put(parkingLot);

    }
}
