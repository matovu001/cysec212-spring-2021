package edu.gannon.intentappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextWebsite;
    EditText mEditTextLocation;
    EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextWebsite = findViewById(R.id.website_edittext);
        mEditTextLocation = findViewById(R.id.location_editext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    public void openActivity(View view) {

        Intent openActivityIntent = new Intent(this, SecondActivity.class);

        startActivity(openActivityIntent);
    }

    public void openWebsite(View view) {

        String websiteURI = mEditTextWebsite.getText().toString();
        Uri uri = Uri.parse(websiteURI);

        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(it);
    }

    public void openLocation(View view) {
        String location = mEditTextLocation.getText().toString();
        Uri addressURI = Uri.parse("geo:0,0?q=" + location);

        Intent locIt = new Intent(Intent.ACTION_VIEW, addressURI);
        startActivity(locIt);
    }

    public void shareText(View view) {
        String text = mShareTextEditText.getText().toString();

        // Build the share intent with the mimetype text/plain and launch
        // a chooser for the user to pick an app.
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();

    }
}