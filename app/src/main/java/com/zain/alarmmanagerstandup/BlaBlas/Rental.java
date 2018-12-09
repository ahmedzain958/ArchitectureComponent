package com.zain.alarmmanagerstandup.BlaBlas;

class Rental {
    private Vehicle mVehicle;
    private int mKilometersRented;
    private int mDaysRented;
    private boolean mIsLate;

    Rental(Vehicle vehicle, int kilometersRented, int daysRented, boolean isLate) {
        this.mVehicle = vehicle;
        this.mKilometersRented = kilometersRented;
        this.mDaysRented = daysRented;
        this.mIsLate = isLate;
    }

     int getKilometersRented() {
        return mKilometersRented;
    }

     Vehicle getVehicle() {
        return mVehicle;
    }

     int getDaysRented() {
        return mDaysRented;
    }

     boolean isLate() {
        return mIsLate;
    }
}
