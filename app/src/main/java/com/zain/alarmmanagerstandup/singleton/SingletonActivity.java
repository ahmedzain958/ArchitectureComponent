package com.zain.alarmmanagerstandup.singleton;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.zain.alarmmanagerstandup.R;

import java.util.Date;

public class SingletonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleton);
        TextView dateTextView = findViewById(R.id.tvDate);
        MyExample myExample = MyExample.getInstance();
        dateTextView.setText((new Date(myExample.getDate())).toString());
    }
}
