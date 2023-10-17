package org.example.ParkingLot.Service;

import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.ParkingLotNotFoundException;
import org.example.ParkingLot.Exception.ParkingSlotNotAvailable;
import org.example.ParkingLot.Models.*;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.ParkingLotRepository;
import org.example.ParkingLot.Repository.TicketRepository;

import java.time.LocalDateTime;

public class TicketServiceIMPL implements TicketService{
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private TicketRepository ticketRepository;

    public TicketServiceIMPL(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket CreateTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws GateNotFoundException, ParkingLotNotFoundException, ParkingSlotNotAvailable {
        ParkingLot parkingLot= parkingLotRepository.get(parkingLotId);
        Gate gate= gateRepository.get(gateId);
        ParkingSlot assignedParkingSlot=parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(),parkingLot,gate);
        Ticket ticket=new Ticket();
        ticket.setEntryTime(entryTime);
        ticket.setVehicle(vehicle);
        ticket.setParkingSlot(assignedParkingSlot);
        return ticketRepository.put(ticket);
    }



}
