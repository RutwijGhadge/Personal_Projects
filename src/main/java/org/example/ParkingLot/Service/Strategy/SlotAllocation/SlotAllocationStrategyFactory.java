package org.example.ParkingLot.Service.Strategy.SlotAllocation;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStategy(){
        return new NearestSlotAllocationStrategy();
    }
}
