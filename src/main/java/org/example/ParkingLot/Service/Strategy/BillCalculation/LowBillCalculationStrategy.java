package org.example.ParkingLot.Service.Strategy.BillCalculation;

import org.example.ParkingLot.Models.Constants.SupportedVehicleType;
import org.example.ParkingLot.Models.Ticket;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy{
    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 80;
    private static final int PER_HOUR_CHARGE_6_8_WHEELER = 100;
    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double calculateBillAmount(Ticket ticket, LocalDateTime ExitTime) {
        LocalDateTime entryTime = ticket.getEntryTime();
        int costPerHour=0;
        long totalHours = ChronoUnit.HOURS.between(ExitTime, entryTime); // 40 mins -> 1 , 1:30 -> 2 2:40 -> 3
        //charge as per the type of vehicle
        if(ticket.getVehicle().getVehicleType().equals(SupportedVehicleType.CAR)){
            costPerHour=PER_HOUR_CHARGE_4_WHEELER;
        }else if(ticket.getVehicle().getVehicleType().equals(SupportedVehicleType.BIKE)){
            costPerHour=PER_HOUR_CHARGE_2_WHEELER;
        }else{
            costPerHour=PER_HOUR_CHARGE_6_8_WHEELER;
        }
        double baseCost = costPerHour  * totalHours;
        return baseCost + (baseCost * (INCREMENT_FACTOR * (totalHours-1)));
    }
}
