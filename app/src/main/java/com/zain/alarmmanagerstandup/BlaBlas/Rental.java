package com.zain.alarmmanagerstandup.BlaBlas;

public class Rental {
    private Vehicle _vehicle;
    private int _kilometersRented;
    private int _daysRented;
    private boolean _lateFee;

    public Rental(Vehicle vehicle, int mileage,int daysRented,boolean lateFee) {
        _vehicle = vehicle;
        _kilometersRented = mileage;
        _daysRented=daysRented;
        _lateFee=lateFee;
    }

    public int getMileage() {
        return _kilometersRented;
    }

    public Vehicle getVehicle() {
        return _vehicle;
    }

    public int getDaysRented() {
        return _daysRented;
    }

    public boolean isLate() {
        return _lateFee;
    }
}
