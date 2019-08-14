package com.example.musicforlife;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.musicforlife.R;
import com.example.musicforlife.users.UsersCollection;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView trailerVideoView = (VideoView) findViewById(R.id.trailerVideoView);
        trailerVideoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.trailer);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(trailerVideoView);
        trailerVideoView.setMediaController(mediaController);


        TextView usernameTextView = findViewById(R.id.usernameTextView);
        usernameTextView.setText(UsersCollection.getCurrentUser().getForename());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.about:
                this.startActivity(new Intent(this, MainActivity.class));
                return true;

            case R.id.buy_tickets:
                this.startActivity(new Intent(this, BuyTicketsActivity.class));
                return true;

            case R.id.date_location:
                this.startActivity(new Intent(this, DateLocationActivity.class));
                return true;

            case R.id.performers:
                this.startActivity(new Intent(this, PerformersActivity.class));
                return true;

            case R.id.logout:

                AlertDialog.Builder logOutAlert = new AlertDialog.Builder(this);
                logOutAlert.setMessage("Are You Sure ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                logOutAlert.setTitle("You Are About To Log Out");
                logOutAlert.show();

                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
