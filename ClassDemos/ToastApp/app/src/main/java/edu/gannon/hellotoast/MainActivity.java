package edu.gannon.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount = (TextView)findViewById(R.id.show_count);
    }

    public void showToast(View view) {

        Toast toast = Toast.makeText(this, "CYSEC212 Toast App!", Toast.LENGTH_LONG);
        toast.show();

    }

    public void countUp(View view) {

        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));

    }
}