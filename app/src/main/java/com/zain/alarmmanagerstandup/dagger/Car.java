package com.zain.alarmmanagerstandup.dagger;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";
    @Inject
    Engine engine;
    Wheel wheel;

    @Inject
    public Car(Engine engine) {
        this.engine = engine;
    }
    @Inject
    public void enableRemote(Remote remote) {
        remote.setListener(this);
    }

    public void drive() {
        Log.d(TAG, "drive: ");
    }
}
