package edu.gannon.intentserviceexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static edu.gannon.intentserviceexample.CashbackIntentService.CASHBACK_REQUEST;

public class MainActivity extends AppCompatActivity {

    TextView textViewResponse;
    EditText editTextMessage;
    ResponseBroadcastReceiver receiver;

    public static final String ACTION_CASHBACK = "edu.gannon.ihack.ACTION_CASHBACK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResponse = findViewById(R.id.textViewResponse);
        editTextMessage = findViewById(R.id.editTextMessage);

        IntentFilter cashbackFilter = new IntentFilter(ACTION_CASHBACK);

        receiver = new ResponseBroadcastReceiver();
        registerReceiver(receiver, cashbackFilter);
    }

    public void startService(View view) {

        String message = editTextMessage.getText().toString();
        Intent serviceIntent = new Intent(this, CashbackIntentService.class);
        serviceIntent.putExtra(CASHBACK_REQUEST, message);
        startService(serviceIntent);

    }

    public class ResponseBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String response = intent.getStringExtra(CashbackIntentService.CASHBACK_RESPONSE);
            textViewResponse.setText(response);
        }
    }
}