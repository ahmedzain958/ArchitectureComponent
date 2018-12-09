package com.zain.alarmmanagerstandup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "after 5 seconds", Toast.LENGTH_SHORT).show();
    }


    public static void main(String[] args) {
        String statement = "{\n" +
                "  \"customers\": [\n" +
                "    {\n" +
                "      \"customer\": " + "\"BlaBla Connect\",\n" +
                "      \"rentals\": [\n" +
                "        {\n" +
                "          \"make_and_model\": \"Blue Honda 2008\",\n" +
                "          \"cost\": 912\n" +
                "        },\n" +
                "        {\n" +
                "          \"make_and_model\": \"Grey Jeep 2013\",\n" +
                "          \"cost\": 850\n" +
                "        },\n" +
                "        {\n" +
                "          \"make_and_model\": \"Red Sunny 2014\",\n" +
                "          \"cost\": 1268.96\n" +
                "        }\n" +
                "      ],\n" +
                "      \"owedAmount\": 3030.96,\n" +
                "      \"rewards\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"customer\": \"Sygmatel\",\n" +
                "      \"rentals\": [\n" +
                "        {\n" +
                "          \"make_and_model\": \"Blue X3 2017\",\n" +
                "          \"cost\": 760\n" +
                "        }\n" +
                "      ],\n" +
                "      \"owedAmount\": 760,\n" +
                "      \"rewards\": 1\n" +
                "    }\n" +
                "  ]\n" +
                "}";
//        System.out.println(json);
    }
}
