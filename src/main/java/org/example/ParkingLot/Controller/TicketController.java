package org.example.ParkingLot.Controller;

import org.example.ParkingLot.DTO.TicketRequestDTO;
import org.example.ParkingLot.DTO.TicketResponseDTO;
import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.ParkingLotNotFoundException;
import org.example.ParkingLot.Exception.ParkingSlotNotAvailable;
import org.example.ParkingLot.Models.Ticket;
import org.example.ParkingLot.Models.Vehicle;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.ParkingLotRepository;
import org.example.ParkingLot.Repository.TicketRepository;
import org.example.ParkingLot.Service.TicketService;
import org.example.ParkingLot.Service.TicketServiceIMPL;

import java.time.LocalDateTime;

public class TicketController {
    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository,
                            TicketRepository ticketRepository) {
        this.ticketService = new TicketServiceIMPL(parkingLotRepository,gateRepository,ticketRepository);
    }

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) throws ParkingLotNotFoundException, ParkingSlotNotAvailable, GateNotFoundException {
        Vehicle vehicle=new Vehicle(ticketRequestDTO.getNumber(), ticketRequestDTO.getName(),
                ticketRequestDTO.getColor(),ticketRequestDTO.getVehicleType());
        Ticket ticket=ticketService.CreateTicket(vehicle,ticketRequestDTO.getGateId(),
                ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO=new TicketResponseDTO();//setting values
        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getSlotNumber());
        ticketResponseDTO.setNumber(ticket.getVehicle().getVehicleNumber());
        return ticketResponseDTO;
    }
}
