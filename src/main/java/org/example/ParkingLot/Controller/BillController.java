package org.example.ParkingLot.Controller;

import org.example.ParkingLot.DTO.BillRequestDTO;
import org.example.ParkingLot.DTO.BillResponseDTO;
import org.example.ParkingLot.DTO.TicketResponseDTO;
import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.TicketNotFoundException;
import org.example.ParkingLot.Models.Bill;
import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.Ticket;
import org.example.ParkingLot.Repository.BillRepository;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.TicketRepository;
import org.example.ParkingLot.Service.BillService;
import org.example.ParkingLot.Service.BillServiceImpl;
import org.example.ParkingLot.Service.TicketService;

import java.time.LocalDateTime;

public class BillController {
    private BillService billService;

    public BillController(TicketRepository ticketRepository, GateRepository gateRepository, BillRepository billRepository) {
        this.billService=new BillServiceImpl(ticketRepository,gateRepository,billRepository);
    }

    public BillResponseDTO createBill(BillRequestDTO billRequestDTO) throws TicketNotFoundException, GateNotFoundException {
        Bill bill=billService.CreateBill(billRequestDTO.getTicketId(),billRequestDTO.getGateId());
        BillResponseDTO billResponseDTO=new BillResponseDTO();
        billResponseDTO.setEntryTime(bill.getTicket().getEntryTime().toString());
        billResponseDTO.setExitTime(bill.getExitTime());
        billResponseDTO.setAmount(bill.getAmount());

        return billResponseDTO;
    }
}
