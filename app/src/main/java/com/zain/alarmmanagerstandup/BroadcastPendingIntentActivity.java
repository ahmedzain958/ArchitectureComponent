package com.zain.alarmmanagerstandup;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BroadcastPendingIntentActivity extends AppCompatActivity {
    Button button;
    private static String SENT_SMS_FLAG = "SENT_SMS";
    private SmsManager mySMS = SmsManager.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_pending_intent);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = "01008279579";
                String msg = "msg msg msg";

                // pre conditions
                if (msg.length() < 1) {  // actually IV == 8!
                    Toast.makeText(BroadcastPendingIntentActivity.this, "Invalid Empty Message", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (msg.length() > 160) {
                    Toast.makeText(BroadcastPendingIntentActivity.this, "Error. Message Is Too Large", Toast.LENGTH_SHORT).show();
                }
                if (destination.length() < 7) {
                    Toast.makeText(BroadcastPendingIntentActivity.this, "Invalid Phone #", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intentSent = new Intent(SENT_SMS_FLAG);
                PendingIntent pendingIntentSent = PendingIntent.getBroadcast(BroadcastPendingIntentActivity.this, 0, intentSent, 0);
                try {
                    checkSmsPermission(destination, pendingIntentSent);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(BroadcastPendingIntentActivity.this, "e.getMessage()", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private static final int PERMISSION_SEND_SMS = 123;

    private void checkSmsPermission(String destination, PendingIntent pendingIntentSent) {
        if (ContextCompat.checkSelfPermission(BroadcastPendingIntentActivity.this,
                Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            // request permission (see result in onRequestPermissionsResult() method)
            ActivityCompat.requestPermissions(BroadcastPendingIntentActivity.this,
                    new String[]{Manifest.permission.SEND_SMS},
                    PERMISSION_SEND_SMS);
        } else {
            // permission already granted run sms send
            mySMS.sendTextMessage(destination, "", "dsdsdsds", pendingIntentSent, null);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_SEND_SMS: {
                Intent intentSent = new Intent(SENT_SMS_FLAG);
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted
                    mySMS.sendTextMessage("+2001008279579", "", "dsdsdsds", PendingIntent.getBroadcast(BroadcastPendingIntentActivity.this, 0, intentSent, 0), null);
                } else {
                    // permission denied
                }
                return;
            }
        }
    }
}
