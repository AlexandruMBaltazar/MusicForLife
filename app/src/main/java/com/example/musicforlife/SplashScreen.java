package com.example.musicforlife;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.musicforlife.progressbaranimation.ProgressBarAnimation;

public class SplashScreen extends AppCompatActivity {

    ProgressBar loadingProgressBar;
    TextView loadingTextView;
    ImageView logoImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title

        getSupportActionBar().hide(); // hide the title bar

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_splashscreen);

        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);
        loadingTextView = (TextView) findViewById(R.id.loadingTextView);
        logoImageView = (ImageView) findViewById(R.id.logoImageView);


        loadingProgressBar.setMax(100);

        setLoadingAnimation();
    }

    public void setLoadingAnimation(){
        final ProgressBarAnimation animation = new ProgressBarAnimation(this,loadingTextView,loadingProgressBar,0f,100f);
        //
        animation.setDuration(8000);
        loadingProgressBar.setAnimation(animation);

        new CountDownTimer(8000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                logoImageView.animate().rotation(720f).setDuration(millisUntilFinished);
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }

}
