package org.example.ParkingLot.Service.Strategy.BillCalculation;

import org.example.ParkingLot.Models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    double calculateBillAmount(Ticket ticket , LocalDateTime ExitTime);
    //exit time and start time is required for calculating Bill
}
