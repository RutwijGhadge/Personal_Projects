package org.example.ParkingLot.Service.Strategy.SlotAllocation;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategy(){
        return new NearestSlotAllocationStrategy();
    }
}
