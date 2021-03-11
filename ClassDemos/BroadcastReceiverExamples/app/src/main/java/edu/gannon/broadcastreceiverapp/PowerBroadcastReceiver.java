package edu.gannon.broadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String intentAction = intent.getAction();
        String message;

        switch (intentAction) {
            case Intent.ACTION_POWER_CONNECTED:
                message = "Power has been connected!";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                message =  "Power has been disconnected!";
                break;
            case MainActivity.ACTION_CUSTOM_BROADCAST:
                message = "Received Custom Broadcast!";
                break;
            default:
                message = "Unknown Intent Action";
        }

        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.show();

    }
}