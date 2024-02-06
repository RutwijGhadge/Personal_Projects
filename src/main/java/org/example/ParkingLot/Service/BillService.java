package org.example.ParkingLot.Service;

import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.TicketNotFoundException;
import org.example.ParkingLot.Models.Bill;


import java.time.LocalDateTime;

public interface BillService {
    Bill CreateBill(int ticketId, int gateId) throws TicketNotFoundException, GateNotFoundException;
}