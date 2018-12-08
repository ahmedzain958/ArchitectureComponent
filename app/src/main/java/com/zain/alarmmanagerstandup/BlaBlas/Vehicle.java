package com.zain.alarmmanagerstandup.BlaBlas;

public class Vehicle {
    public static final int SUV = 2;
    public static final int SEDAN = 0;
    public static final int FOURxFOUR = 1;
    private String _makeAndModel;
    private int _rateCode;

    public Vehicle(String makeAndModel, int rateCode) {
        _makeAndModel = makeAndModel;
        _rateCode = rateCode;
    }

    public int getRateCode() {
        return _rateCode;
    }

    public void setRateCode(int arg) {
        _rateCode = arg;
    }

    public String getMakeAndModel() {
        return _makeAndModel;
    }
}
