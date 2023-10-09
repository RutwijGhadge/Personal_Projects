package org.example.ParkingLot.Exception;

public class ParkingSlotNotFoundException extends Exception {
    public ParkingSlotNotFoundException() {
    }

    public ParkingSlotNotFoundException(String message) {
        super(message);
    }
}
