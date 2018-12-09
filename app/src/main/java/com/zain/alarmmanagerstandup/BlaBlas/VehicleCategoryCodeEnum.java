package com.zain.alarmmanagerstandup.BlaBlas;

public enum VehicleCategoryCodeEnum {
    SEDAN(0), FOURxFOUR(1), SUV(2);

    private final int value;

    VehicleCategoryCodeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
