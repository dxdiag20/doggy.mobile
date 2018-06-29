package com.doggy.doggy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

public class SplashActivity extends Activity {
    private AnimationDrawable animi;
    private ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ch);

        im = (ImageView) findViewById(R.id.imageAnimation);
        im.setBackgroundResource(R.drawable.animation);
        animi = (AnimationDrawable) im.getBackground();
        animi.start();

        Log.e("bsos1202", "SplashActivity income!!");
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 4900); // 3초 후 이미지를 닫습니다
    }
}