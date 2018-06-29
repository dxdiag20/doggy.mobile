package com.doggy.doggy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TakePicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_pic);

        // TODO: Make a camera logic. CameraBridgeViewBase.CvCameraViewListener2 may be used.

        Button cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(TakePicActivity.this, AdjustPicActivity.class));
                    }
                }
        );
    }
}
