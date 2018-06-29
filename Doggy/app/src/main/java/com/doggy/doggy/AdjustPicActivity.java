package com.doggy.doggy;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdjustPicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_pic);

        // TODO SEJIN: Get image from TakePicActivity and put it in facePictureView.
        ImageView facePictureView = findViewById(R.id.facePicture);
        facePictureView.setImageResource(R.drawable.test);

        Button adjustButton = findViewById(R.id.adjustButton);
        adjustButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(AdjustPicActivity.this, HttpSndRcvActivity.class));
                    }
                }
        );
    }
}
