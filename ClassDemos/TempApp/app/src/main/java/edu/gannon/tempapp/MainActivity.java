package edu.gannon.tempapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText mEditTextTemp;
    TextView mTextViewResult;
    Button mButtonReset;
    Spinner mSpinnerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextTemp = (EditText)findViewById(R.id.editTextTemperature);
        mTextViewResult = (TextView)findViewById(R.id.textViewResult);
        mButtonReset = (Button)findViewById(R.id.buttonReset);

        mEditTextTemp.setText("0");

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditTextTemp.setText("0");
                mTextViewResult.setText("0");
            }
        });

        mSpinnerChoice = (Spinner)findViewById(R.id.spinnerSelect);
        mSpinnerChoice.setOnItemSelectedListener(this);

        // Adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choices, android.R.layout.simple_spinner_item);

        mSpinnerChoice.setAdapter(adapter);

    }

    public void convertTemperature(View view) {
        String input = mEditTextTemp.getText().toString();
        double inputTemp = Double.parseDouble(input);

        //(32°F − 32) × 5/9
        double centigrade = ((inputTemp - 32) * 5) / 9;
        mTextViewResult.setText(String.valueOf(centigrade));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}