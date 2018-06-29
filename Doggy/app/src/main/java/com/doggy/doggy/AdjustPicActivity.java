package com.doggy.doggy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AdjustPicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_snd_rcv);

        Button adjustButton = findViewById(R.id.adjustButton);
        adjustButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(AdjustPicActivity.this, ShowResultActivity.class));
                    }
                }
        );
    }
}
