package org.example.ParkingLot.Service;

import org.example.ParkingLot.Exception.GateNotFoundException;
import org.example.ParkingLot.Exception.TicketNotFoundException;
import org.example.ParkingLot.Models.Bill;
import org.example.ParkingLot.Models.Gate;
import org.example.ParkingLot.Models.Ticket;
import org.example.ParkingLot.Repository.BillRepository;
import org.example.ParkingLot.Repository.GateRepository;
import org.example.ParkingLot.Repository.TicketRepository;
import org.example.ParkingLot.Service.Strategy.BillCalculation.BillCalculationStrategyFactory;

import java.time.Duration;
import java.time.LocalDateTime;

public class BillServiceImpl implements BillService {
    private TicketRepository ticketRepository;
    private GateRepository gateRepository;
    private BillRepository billRepository;

    public BillServiceImpl(TicketRepository ticketRepository, GateRepository gateRepository, BillRepository billRepository) {
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.billRepository = billRepository;
    }

    @Override
    public Bill CreateBill(int ticketId, int gateId) throws TicketNotFoundException, GateNotFoundException {
       Ticket ticket=ticketRepository.get(ticketId);
       Gate gates = gateRepository.get(gateId);
      // LocalDateTime entryTime= ticketRepository.get(ticket.getId()).getEntryTime();
       double amount= BillCalculationStrategyFactory.getBillCalculationStrategy().calculateBillAmount(ticket,LocalDateTime.now());
       Bill bill=new Bill();
       bill.setTicket(ticket);
       bill.setGate(gates);
       bill.setExitTime(LocalDateTime.now().toString());
       bill.setAmount(amount);
       //bill.setPayment(payment);
       return billRepository.put(bill);//updated the Bill Repository
    }
}
