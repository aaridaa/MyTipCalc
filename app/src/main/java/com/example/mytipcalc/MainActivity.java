package com.example.mytipcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton poor, mediocre, good, excellent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poor = (RadioButton) findViewById(R.id.poorRadio);
        poor.setOnClickListener(this);
        mediocre = (RadioButton) findViewById(R.id.mediocreRadio);
        mediocre.setOnClickListener(this);
        good = (RadioButton) findViewById(R.id.goodRadio);
        good.setOnClickListener(this);
        excellent = (RadioButton) findViewById(R.id.excellentRadio);
        excellent.setOnClickListener(this);
    }

    public void getTip(View v) {
        // get refrences to all elements on app screen
        EditText billEditText = (EditText) findViewById(R.id.billEditText);
        EditText percentEditText = (EditText) findViewById(R.id.percentEditText);
        TextView tipTextView = (TextView) findViewById(R.id.tipTextView);
        TextView totalTextView = (TextView) findViewById(R.id.totalTextView);

        //get the values from the EditText boxes and convert them to double data types
        double bill = Double.parseDouble(billEditText.getText().toString());
        double percent = Double.parseDouble(percentEditText.getText().toString());



        percent = percent / 100;
        double tip = bill * percent;
        double total = bill + tip;
        NumberFormat numberFormat  = new DecimalFormat("#.00");

        tipTextView.setText("Tip: $" + numberFormat.format(tip));
        totalTextView.setText("Total: $" + numberFormat.format(total));




    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.poorRadio:
                if (poor.isChecked())
                    Toast.makeText(getApplicationContext(), "We're sorry you had a poor experience :(", Toast.LENGTH_LONG).show();
                break;

            case R.id.mediocreRadio:
                if (mediocre.isChecked())
                Toast.makeText(getApplicationContext(), "Please consider coming again", Toast.LENGTH_LONG).show();
                break;
            case R.id.goodRadio:
                if (good.isChecked())
                    Toast.makeText(getApplicationContext(), "We're glad you enjoyed!", Toast.LENGTH_LONG).show();
                break;
            case R.id.excellentRadio:
                if (excellent.isChecked())
                    Toast.makeText(getApplicationContext(), ":)", Toast.LENGTH_LONG).show();
                break;


        }


    }

    public void onClick2(View v)
    {
        EditText billEditText = (EditText) findViewById(R.id.billEditText);
        EditText percentEditText = (EditText) findViewById(R.id.percentEditText);

        if ((billEditText.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(), "enter value for bill", Toast.LENGTH_LONG).show();
        }
    }

}