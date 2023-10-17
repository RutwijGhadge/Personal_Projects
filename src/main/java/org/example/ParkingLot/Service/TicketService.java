package org.example.ParkingLot.Service;

import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.ParkingLotNotFoundException;
import org.example.ParkingLot.Exception.ParkingSlotNotAvailable;
import org.example.ParkingLot.Models.Ticket;
import org.example.ParkingLot.Models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket CreateTicket(Vehicle vehicle, int gateId, int parkingLotId, LocalDateTime entryTime) throws GateNotFoundException, ParkingLotNotFoundException, ParkingSlotNotAvailable;
}
