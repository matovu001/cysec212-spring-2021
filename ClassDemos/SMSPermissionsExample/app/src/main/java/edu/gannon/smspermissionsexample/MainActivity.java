package edu.gannon.smspermissionsexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextPhoneNo;
    EditText editTextMessage;
    final static int PERMISSION_REQUEST_SMS_SEND_CODE = 10;
    String phoneNumber;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.editTextTextMultiLine);
        editTextPhoneNo = findViewById(R.id.editTextPhone);
    }

    public void sendSMS(View view) {

        phoneNumber = editTextPhoneNo.getText().toString();
        message = editTextMessage.getText().toString();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)
        != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[] { Manifest.permission.SEND_SMS },
                        PERMISSION_REQUEST_SMS_SEND_CODE);
            }

        } else {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);

            Toast.makeText(this, "SMS Successfully sent.", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_SMS_SEND_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(this, "SMS Permission Accepted.",
                            Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "SMS Permission Denied.",
                            Toast.LENGTH_SHORT).show();
                }
        }
    }

    /*
    public void sendSMS(View view) {

        String phoneNumber = editTextPhoneNo.getText().toString();
        String message = editTextMessage.getText().toString();

        // "smsto: " + phoneNumber;
        String smsUri = String.format("smsto: %s", phoneNumber);
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(smsUri));
        smsIntent.putExtra("sms_body", message);

        startActivity(smsIntent);

    }
    */

}