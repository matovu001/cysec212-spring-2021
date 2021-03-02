package edu.gannon.locationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private final static String TAG = MainActivity.class.getSimpleName();

    EditText mLocationEditText;
    Button mShowLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Restore any saved instance state
        super.onCreate(savedInstanceState);

        // Set content view
        setContentView(R.layout.activity_main);

        // Initialize UI Elements
        mLocationEditText = findViewById(R.id.location);
        mShowLocationButton = findViewById(R.id.show_location);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "The activity is visible and about to be started.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "The activity is visible and about to be restarted.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "The activity is and has focus (it is now \"resumed\")");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,
                "Another activity is taking focus (this activity is about to be \"paused\")");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "The activity is no longer visible (it is now \"stopped\")");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "The activity is about to be destroyed.");
    }

    public void showLocation(View view) {
        try {
            String location = mLocationEditText.getText().toString();
            location = location.replace(' ', '+');

            Uri locationUri = Uri.parse("geo:0,0?q=" + location);
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, locationUri);

            startActivity(mapIntent);

        } catch (Exception e) {
            // Log any error messages
            Log.e(TAG, "showLocation click: " + e.toString() );
        }
    }
}