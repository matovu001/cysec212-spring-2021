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
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    EditText mEditTextTemp;
    TextView mTextViewResult;
    Button mButtonReset;
    Spinner mSpinnerChoice;
    String selectedItem;

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
        if (selectedItem.equals("FtoC")) {
            double centigrade = ((inputTemp - 32) * 5) / 9;
            mTextViewResult.setText(String.valueOf(centigrade));
        } else {
            double fh = ((inputTemp *9) + 32) / 5;
            mTextViewResult.setText(String.valueOf(fh));
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        selectedItem = parent.getItemAtPosition(position).toString();

        // Toast.makeText(this, selectedItem, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}