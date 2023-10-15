package org.example.ParkingLot.Repository;

import org.example.ParkingLot.Exception.TicketNotFoundException;
import org.example.ParkingLot.Models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    public TicketRepository() {
    }

    private HashMap<Integer, Ticket> ticketMap=new HashMap<Integer, Ticket>();

    public TicketRepository(HashMap<Integer, Ticket> ticketMap) {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId) throws TicketNotFoundException {
        Ticket ticket=ticketMap.get(ticketId);//getting ticket from the hashmap-> if null then throw exception else return the ticket
        if(ticket==null)
            throw new TicketNotFoundException("Ticket Not present with Id"+ticketId);
        return ticket;
    }

    public Ticket put(Ticket ticket){
        ticketMap.put(ticket.getId(),ticket); //inserting the ticket in the map
        return ticket;
    }
}
