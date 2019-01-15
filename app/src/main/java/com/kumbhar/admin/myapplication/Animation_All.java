package com.kumbhar.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class Animation_All extends AppCompatActivity {

    Button btnFadein,btnFadeout,btnBlink,btnZoomIn,btnZoomOut,btnRotate,btnMove,btnSlideUp,btnSlideDown,btnBounce,btnSequential;
    TextView tvFadein,tvFadeout,tvBlink,tvZoomIn,tvZoomOut,tvRotate,tvMove,tvSlideUp,tvSlideDown,tvBounce,tvSequential;
    Animation fadein,fadeout,blink,zoomIn,zoomout,rotate,move,slideUp,slideDown,bounce,sequential;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation__all);

        btnFadein = (Button) findViewById(R.id.btnFadein);
        tvFadein = (TextView) findViewById(R.id.tvFadein);
        btnFadeout = (Button) findViewById(R.id.btnFadeout);
        tvFadeout = (TextView) findViewById(R.id.tvFadeout);
        btnBlink = (Button) findViewById(R.id.btnBlink);
        tvBlink = (TextView) findViewById(R.id.tvBlink);
        btnZoomIn = (Button) findViewById(R.id.btnZoomIn);
        tvZoomIn = (TextView) findViewById(R.id.tvZoomIn);
        btnZoomOut = (Button) findViewById(R.id.btnZoomOut);
        tvZoomOut = (TextView) findViewById(R.id.tvZoomOut);
        btnRotate = (Button) findViewById(R.id.btnRotate);
        tvRotate = (TextView) findViewById(R.id.tvRotate);
        btnMove = (Button) findViewById(R.id.btnMove);
        tvMove = (TextView) findViewById(R.id.tvMove);
        btnSlideUp = (Button) findViewById(R.id.btnSlideUp);
        tvSlideUp = (TextView) findViewById(R.id.tvSlideUp);
        btnSlideDown = (Button) findViewById(R.id.btnSlideDown);
        tvSlideDown = (TextView) findViewById(R.id.tvSlideDown);
        btnBounce = (Button) findViewById(R.id.btnBounce);
        tvBounce = (TextView) findViewById(R.id.tvBounce);
        btnSequential = (Button) findViewById(R.id.btnSequential);
        tvSequential = (TextView) findViewById(R.id.tvSequential);

        fadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        fadeout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        zoomIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        zoomout = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        slideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        bounce = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        sequential = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequntial);


        btnFadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFadein.setVisibility(View.VISIBLE);
                tvFadein.startAnimation(fadein);

            }
        });

        btnFadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFadeout.setVisibility(View.VISIBLE);
                tvFadeout.startAnimation(fadeout);
            }
        });

        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBlink.setVisibility(View.VISIBLE);
                tvBlink.startAnimation(blink);
            }
        });

        btnZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvZoomIn.setVisibility(View.VISIBLE);
                tvZoomIn.startAnimation(zoomIn);
            }
        });

        btnZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvZoomOut.setVisibility(View.VISIBLE);
                tvZoomOut.startAnimation(zoomout);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvRotate.setVisibility(View.VISIBLE);
                tvRotate.startAnimation(rotate);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMove.setVisibility(View.VISIBLE);
                tvMove.startAnimation(move);
            }
        });

        btnSlideUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSlideUp.setVisibility(View.VISIBLE);
                tvSlideUp.startAnimation(slideUp);
            }
        });

        btnSlideDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSlideDown.setVisibility(View.VISIBLE);
                tvSlideDown.startAnimation(slideDown);
            }
        });

        btnBounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBounce.setVisibility(View.VISIBLE);
                tvBounce.startAnimation(bounce);
            }
        });

        btnSequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSequential.setVisibility(View.VISIBLE);
                tvSequential.startAnimation(sequential);
            }
        });
    }
}
