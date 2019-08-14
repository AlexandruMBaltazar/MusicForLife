package com.example.musicforlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class BuyTicketsActivity extends AppCompatActivity {
    private Spinner adultTicketsSpinner;
    private Spinner childTicketsSpinner;
    private TextView totalTextView;
    private int totalAdult = 0;
    private int totalChild = 0;
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_tickets);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        totalTextView = findViewById(R.id.grandTotalTextView);

        adultTicketsSpinner = findViewById(R.id.adultTicketsSpinner);
        childTicketsSpinner = findViewById(R.id.childTicketsSpinner);


        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(BuyTicketsActivity.this,R.layout.spinner_item,getResources().getStringArray(R.array.Tickets));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adultTicketsSpinner.setAdapter(myAdapter);
        adultTicketsSpinner.setSelection(0);

        adultTicketsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             switch (position){
                 case 0:
                     totalAdult = Integer.parseInt((String)adultTicketsSpinner.getItemAtPosition(position)) * 10;
                     break;

                 case 1:
                     totalAdult = Integer.parseInt((String)adultTicketsSpinner.getItemAtPosition(position)) * 10;
                     break;

                 case 2:
                     totalAdult = Integer.parseInt((String)adultTicketsSpinner.getItemAtPosition(position)) * 10;
                     break;

                 case 3:
                     totalAdult = Integer.parseInt((String)adultTicketsSpinner.getItemAtPosition(position)) * 10;
                     break;

                 case 4:
                     totalAdult = Integer.parseInt((String)adultTicketsSpinner.getItemAtPosition(position)) * 10;
                     break;
             }
                total = totalAdult + totalChild;
                totalTextView.setText(Integer.toString(total));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        childTicketsSpinner.setAdapter(myAdapter);
        childTicketsSpinner.setSelection(0);

        childTicketsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        totalChild = Integer.parseInt((String)childTicketsSpinner.getItemAtPosition(position)) * 5;
                        break;

                    case 1:
                        totalChild = Integer.parseInt((String)childTicketsSpinner.getItemAtPosition(position)) * 5;
                        break;

                    case 2:
                        totalChild = Integer.parseInt((String)childTicketsSpinner.getItemAtPosition(position)) * 5;
                        break;

                    case 3:
                        totalChild = Integer.parseInt((String)childTicketsSpinner.getItemAtPosition(position)) * 5;
                        break;

                    case 4:
                        totalChild = Integer.parseInt((String)childTicketsSpinner.getItemAtPosition(position)) * 5;
                        break;
                }
                total = totalAdult + totalChild;
                totalTextView.setText(Integer.toString(total));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void buyTicketsButtonClicked(View view){
        Intent paymentIntent = new Intent(this, PayActivity.class);
        paymentIntent.putExtra("adult tickets", Integer.toString(totalAdult / 10));
        paymentIntent.putExtra("adult total", Integer.toString((totalAdult / 10) * 10));
        paymentIntent.putExtra("child tickets", Integer.toString(totalChild / 5));
        paymentIntent.putExtra("child total", Integer.toString((totalChild / 5) * 5));
        paymentIntent.putExtra("total",Integer.toString(total));

        startActivity(paymentIntent);
        finish();
    }

}
