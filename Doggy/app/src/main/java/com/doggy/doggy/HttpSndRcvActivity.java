package com.doggy.doggy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HttpSndRcvActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_snd_rcv);
        startActivity(new Intent(HttpSndRcvActivity.this, ShowResultActivity.class));
    }
}
