package com.zain.alarmmanagerstandup.BlaBlas;

public class Vehicle {
    public static final int SUV = 2;
    public static final int SEDAN = 0;
    public static final int FOURxFOUR = 1;
    private String mMakeAndModel;
    private int mVehicleCategoryCode;

    public Vehicle(String makeAndModel, int vehicleCategoryCode) {
        this.mMakeAndModel = makeAndModel;
        this.mVehicleCategoryCode = vehicleCategoryCode;
    }

    public int getVehicleCategoryCode() {
        return mVehicleCategoryCode;
    }

    public void setVehicleCategoryCode(int vehicleCategoryCode) {
        mVehicleCategoryCode = vehicleCategoryCode;
    }

    public String getMakeAndModel() {
        return mMakeAndModel;
    }
}
