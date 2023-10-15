package org.example.ParkingLot.Service.Strategy.BillCalculation;

public class BillCalculationStrategyFactory {
    public static LowBillCalculationStrategy getBillCalculationStrategy(){
        return new LowBillCalculationStrategy();
    }
}
