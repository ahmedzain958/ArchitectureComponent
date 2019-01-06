package com.zain.alarmmanagerstandup.dagger.daggerexample;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.zain.alarmmanagerstandup.R;

import javax.inject.Inject;
import java.util.Date;

public class DaggerExampleActivity extends AppCompatActivity {

    @Inject
    MyExample mMyExample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger_example);
        TextView dateTextView = findViewById(R.id.tvDate);
        ((MyApplication) getApplication()).getMyComponent()
                .inject(DaggerExampleActivity.this);
        dateTextView.setText((new Date(mMyExample.getDate())).toString());
    }

}
