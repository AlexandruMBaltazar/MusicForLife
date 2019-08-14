package com.example.musicforlife.progressbaranimation;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.musicforlife.LogInActivity;

public class ProgressBarAnimation extends Animation {

    private Context context;
    private TextView loadingTextView;
    private ProgressBar loadingProgressBar;
    private float from;
    private float to;

    public ProgressBarAnimation(Context context, TextView loadingTextView, ProgressBar loadingProgressBar, float from, float to){
        this.context = context;
        this.loadingTextView = loadingTextView;
        this.loadingProgressBar = loadingProgressBar;
        this.from = from;
        this.to = to;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        loadingProgressBar.setProgress((int) value);
        loadingTextView.setText((int)value +"  %");

        if(value == to){
            context.startActivity(new Intent(context, LogInActivity.class));
        }
    }
}
