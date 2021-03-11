package edu.gannon.serviceexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playMusic(View view) {
        Intent musicServiceIntent = new Intent(this, MusicPlayerService.class);
        startService(musicServiceIntent);
    }

    public void stopMusic(View view) {
        Intent musicIntent = new Intent(this, MusicPlayerService.class);
        stopService(musicIntent);
    }
}