package org.example.ParkingLot.Exception;

public class BillNotFoundException extends Throwable {
    public BillNotFoundException() {
    }

    public BillNotFoundException(String message) {
        super(message);
    }
}