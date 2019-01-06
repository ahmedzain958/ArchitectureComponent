package com.zain.alarmmanagerstandup.dagger;

import android.util.Log;

import javax.inject.Inject;

public class Wheel {
    private static final String TAG = "Wheel";

    @Inject
    public Wheel() {
        Log.d(TAG, "from const wheel");
    }

    public void rotate(){
        Log.d(TAG, "rotate");
    }
}
