package edu.gannon.broadcastreceiverapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final String ACTION_CUSTOM_BROADCAST = "edu.gannon.ihack.ACTION_CUSTOM_BROADCAST";

    PowerBroadcastReceiver mPowerReceiver = new PowerBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter powerFilter = new IntentFilter();
        powerFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        powerFilter.addAction(Intent.ACTION_POWER_CONNECTED);

        this.registerReceiver(mPowerReceiver, powerFilter);

        IntentFilter localFilter = new IntentFilter(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).registerReceiver(mPowerReceiver, localFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(mPowerReceiver);
    }

    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);
    }
}