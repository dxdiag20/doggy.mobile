package com.doggy.doggy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton takePicButton = (ImageButton) findViewById(R.id.takePicButton);
        takePicButton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {

                    }
                }
        );
    }
}
