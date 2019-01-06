package com.zain.alarmmanagerstandup.dagger;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.zain.alarmmanagerstandup.R;

import javax.inject.Inject;

public class DaggerActivity extends AppCompatActivity {

    @Inject
    Car car;
    @Inject
    Wheel wheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        CarComponent carComponent = DaggerCarComponent.create();
        carComponent.inject(this);
        car.drive();
        wheel.rotate();
    }
}
