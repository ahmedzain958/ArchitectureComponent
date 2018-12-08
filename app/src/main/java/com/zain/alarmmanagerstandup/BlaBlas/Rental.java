package com.zain.alarmmanagerstandup.BlaBlas;

public class Rental {
    private Vehicle _vehicle;
    private int mKilometersRented;
    private int _daysRented;
    private boolean _lateFee;

    public Rental(Vehicle vehicle, int kilometersRented, int daysRented, boolean lateFee) {
        this._vehicle = vehicle;
        this.mKilometersRented = kilometersRented;
        this._daysRented = daysRented;
        this._lateFee = lateFee;
    }

    public int getKilometersRented() {
        return mKilometersRented;
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
