package com.zain.alarmmanagerstandup.BlaBlas;

public class Vehicle {

    private String mMakeAndModel;
    private int mVehicleCategoryCode;

    public Vehicle(String makeAndModel, int vehicleCategoryCode) {
        this.mMakeAndModel = makeAndModel;
        this.mVehicleCategoryCode = vehicleCategoryCode;
    }

    public int getVehicleCategoryCode() {
        return mVehicleCategoryCode;
    }

    String getMakeAndModel() {
        return mMakeAndModel;
    }
}
