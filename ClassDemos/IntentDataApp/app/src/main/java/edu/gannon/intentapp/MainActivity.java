package edu.gannon.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "edu.gannon.intentapp.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchSecondActivity(View view) {

        Intent secondIntent = new Intent(this, SecondActivity.class);
        secondIntent.putExtra(EXTRA_MESSAGE, "Help");
        startActivity(secondIntent);

    }
}