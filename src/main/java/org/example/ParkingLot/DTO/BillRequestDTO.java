package org.example.ParkingLot.DTO;

import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.Ticket;

import java.time.LocalDateTime;

public class BillRequestDTO {
    private int ticketId;
    private int gateId;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getGateId() {
        return gateId;
    }

    public void setGateId(int gateId) {
        this.gateId = gateId;
    }
}
