package org.example.ParkingLot.Exception;

public class ParkingSlotNotAvailable extends Exception {
    public ParkingSlotNotAvailable() {
    }

    public ParkingSlotNotAvailable(String message) {
        super(message);
    }
}
