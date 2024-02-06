package org.example.ParkingLot;

import org.example.ParkingLot.Controller.BillController;
import org.example.ParkingLot.Controller.TicketController;
import org.example.ParkingLot.DTO.BillRequestDTO;
import org.example.ParkingLot.DTO.BillResponseDTO;
import org.example.ParkingLot.DTO.TicketRequestDTO;
import org.example.ParkingLot.DTO.TicketResponseDTO;
import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.ParkingLotNotFoundException;
import org.example.ParkingLot.Exception.ParkingSlotNotAvailable;
import org.example.ParkingLot.Exception.TicketNotFoundException;
import org.example.ParkingLot.Models.Constants.SupportedVehicleType;
import org.example.ParkingLot.Models.ParkingLot;
import org.example.ParkingLot.Repository.*;
import org.example.ParkingLot.Service.initService;
import org.example.ParkingLot.Service.initServiceIMPL;

public class ParkingLotMain {
    public static void main(String[] args) throws ParkingLotNotFoundException, ParkingSlotNotAvailable, GateNotFoundException, TicketNotFoundException {
        ParkingLotRepository parkingLotRepository=new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository=new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository=new ParkingSlotRepository();
        GateRepository gateRepository=new GateRepository();
        BillRepository billRepository=new BillRepository();
        TicketRepository ticketRepository=new TicketRepository();

        initService initservice=new initServiceIMPL(gateRepository,parkingFloorRepository,parkingLotRepository,
                parkingSlotRepository);
        initservice.run();

        TicketController ticketController=new TicketController(parkingLotRepository,gateRepository,ticketRepository);
        TicketRequestDTO ticketRequestDTO=new TicketRequestDTO();
        ticketRequestDTO.setParkingLotId(1);
        ticketRequestDTO.setGateId(31);
        ticketRequestDTO.setName("BMW");
        ticketRequestDTO.setVehicleType(SupportedVehicleType.CAR);
        ticketRequestDTO.setColor("BLACK");
        ticketRequestDTO.setNumber("MH 12 AL 4242");

        TicketResponseDTO ticketResponseDTO= ticketController.createTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);

        BillController billController=new BillController(ticketRepository,gateRepository,billRepository);
        BillRequestDTO billRequestDTO=new BillRequestDTO();

        billRequestDTO.setTicketId(1);//ticketId=parkingLotId
        billRequestDTO.setGateId(31);

        BillResponseDTO billResponseDTO=billController.createBill(billRequestDTO);
        System.out.println(billResponseDTO);

    }
}
