package com.doggy.doggy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        TextView instructionTextView = findViewById(R.id.instructionTextView);
        String instructionString = "<b>나와 닮은 개 찾기</b>를 시작하려면<br/>이 버튼을 클릭해주세요!";
        instructionTextView.setText(Html.fromHtml(instructionString));

        ImageButton takePicButton = findViewById(R.id.takePicButton);
        takePicButton.setOnClickListener(
                new ImageButton.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, AdjustPicActivity.class));
                    }
                }
        );
    }
}
