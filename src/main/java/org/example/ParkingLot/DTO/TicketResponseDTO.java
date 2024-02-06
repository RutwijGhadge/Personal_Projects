package org.example.ParkingLot.DTO;

import org.example.ParkingLot.Models.Constants.SupportedVehicleType;

public class TicketResponseDTO {//gives response to user
    private int ticketId;
    private String entryTime;
    private String number;
    private int slotNumber;

    @Override
    public String toString() {
        return "TicketResponseDTO{" +
                "entryTime='" + entryTime + '\''+
                ", number='" + number + '\'' +
                ", slotNumber=" + slotNumber +
                '}';
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
}
