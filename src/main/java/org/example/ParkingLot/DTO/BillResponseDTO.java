package org.example.ParkingLot.DTO;

import org.example.ParkingLot.Models.Constants.PaymentStatus;

import java.time.LocalDateTime;

public class BillResponseDTO {
    private double Amount;
    private String entryTime;
    private String exitTime;

    @Override
    public String toString() {
        return "BillResponseDTO{" +
                "Amount=" + Amount +
                ", entryTime='" + entryTime + '\'' +
                ", exitTime='" + exitTime + '\'' +
                '}';
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

}
