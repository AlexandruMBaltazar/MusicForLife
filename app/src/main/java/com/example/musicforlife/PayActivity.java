package com.example.musicforlife;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PayActivity extends AppCompatActivity {

    private Spinner monthSpinner;
    private Spinner yearSpinner;
    private EditText cardNumberEditText;
    private EditText cvvEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        TextView adultTickets = findViewById(R.id.adultQuantityTextView);
        TextView adultTotal = findViewById(R.id.adultTotalTextView);
        TextView childTickets = findViewById(R.id.childQuantityTextView);
        TextView childTotal = findViewById(R.id.childTotalTextView);
        TextView total = findViewById(R.id.grandTotalTextView);

        cardNumberEditText = findViewById(R.id.cardNumberEditText);
        cvvEditText = findViewById(R.id.cvvEditText);


        adultTickets.setText(getIntent().getExtras().getString("adult tickets"));
        adultTotal.setText(getIntent().getExtras().getString("adult total"));
        childTickets.setText(getIntent().getExtras().getString("child tickets"));
        childTotal.setText(getIntent().getExtras().getString("child total"));
        total.setText(getIntent().getExtras().getString("total"));

        monthSpinner = findViewById(R.id.monthSpinner);
        ArrayAdapter<String> monthSpinnerAdapter = new ArrayAdapter<String>(PayActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Months));

        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthSpinner.setAdapter(monthSpinnerAdapter);

        yearSpinner = findViewById(R.id.yearSpinner);
        ArrayAdapter<String> yearSpinnerAdapter = new ArrayAdapter<String>(PayActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Years));

        yearSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(yearSpinnerAdapter);

    }

    public void payNowButtonClicked(View view){

        if(cardNumberEditText.getText().toString().isEmpty() || cardNumberEditText.getText().toString().length() < 16){
            AlertDialog.Builder cardNumberAlert = new AlertDialog.Builder(this);
            cardNumberAlert.setMessage("Wrong Card Number - 16 Digits Required").setCancelable(false).setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            cardNumberAlert.setTitle("Wrong Card Number");
            cardNumberAlert.show();

        }else if (monthSpinner.getSelectedItem() == null || yearSpinner.getSelectedItem() == null){
            AlertDialog.Builder dateAlert = new AlertDialog.Builder(this);
            dateAlert.setMessage("Expiration Date Missing").setCancelable(false).setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            dateAlert.setTitle("Wrong Expiration Date");
            dateAlert.show();

        }else if(cvvEditText.getText().toString().isEmpty() || cvvEditText.getText().toString().length() != 3 ){
            AlertDialog.Builder cvvNumberAlert = new AlertDialog.Builder(this);
            cvvNumberAlert.setMessage("Wrong CVV number - 3 digits are required").setCancelable(false).setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            cvvNumberAlert.setTitle("Wrong CVV Number");
            cvvNumberAlert.show();


        }else{
            long referenceNumber = Math.round(Math.random() * 100000);

            AlertDialog.Builder paymentCompleteAlert = new AlertDialog.Builder(this);
            paymentCompleteAlert.setMessage("Thanks For Your Help !\n Please provide this reference number at the gate: " + referenceNumber).setCancelable(false).setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    PayActivity.this.startActivity(new Intent(PayActivity.this, MainActivity.class));
                }
            });

            paymentCompleteAlert.setTitle("Payment Complete");
            paymentCompleteAlert.show();
        }

    }
}
