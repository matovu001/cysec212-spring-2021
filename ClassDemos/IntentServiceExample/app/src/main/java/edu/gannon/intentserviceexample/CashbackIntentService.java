package edu.gannon.intentserviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;

import androidx.annotation.Nullable;

public class CashbackIntentService extends IntentService {

    public static final String CASHBACK_REQUEST = "CASHBACK_REQUEST";
    public static final String CASHBACK_RESPONSE = "CASHBACK_RESPONSE";

    public CashbackIntentService() {
        super("Cashback Intent Service");
    }

    public String getCashBack(String userCategory) {
        String cashBack;
        if (userCategory.equalsIgnoreCase("fashion")) {
            cashBack = "Up to 60% cashback on all fashion items";
        } else if (userCategory.equalsIgnoreCase("electronics")) {
            cashBack = "Up to 40% cashback on electronics";
        } else {
            cashBack = "Flat 30% on all other categories";
        }
        return cashBack;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String userCategory = intent.getStringExtra(CASHBACK_REQUEST);

        // Pause for 30 seconds, pretending to do work such as a
        // long running process e.g., getting data from internet
        SystemClock.sleep(3000);
        String cashBack = getCashBack(userCategory);

        // Send broadcast
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.ACTION_CASHBACK);
        broadcastIntent.putExtra(CASHBACK_RESPONSE, cashBack);
        sendBroadcast(broadcastIntent);

    }
}