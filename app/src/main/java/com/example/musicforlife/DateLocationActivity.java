package com.example.musicforlife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DateLocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_location);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void findUsButtonClicked (View view){
        this.startActivity(new Intent(this, LocationActivity.class));
    }

}
