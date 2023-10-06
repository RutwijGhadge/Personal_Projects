package org.example.ParkingLot.Models;

import org.example.ParkingLot.Models.Constants.GateStatus;
import org.example.ParkingLot.Models.Constants.GateType;

public class Gate extends BaseModel {
    private Operator operator;
    private GateType gateType;
    private int floornumber;
    private int parkinglotid;
    private GateStatus gateStatus;
    private int gatenumber;

    public int getGatenumber() {
        return gatenumber;
    }

    public void setGatenumber(int gatenumber) {
        this.gatenumber = gatenumber;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getFloornumber() {
        return floornumber;
    }

    public void setFloornumber(int floornumber) {
        this.floornumber = floornumber;
    }

    public int getParkinglotid() {
        return parkinglotid;
    }

    public void setParkinglotid(int parkinglotid) {
        this.parkinglotid = parkinglotid;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
