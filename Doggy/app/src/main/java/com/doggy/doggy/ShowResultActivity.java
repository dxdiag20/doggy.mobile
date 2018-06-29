package com.doggy.doggy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ShowResultActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    private ImageView mImageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_show_result);
        mViewpager = (ViewPager) findViewById(R.id.viewpager);
//        mImageView3 = (ImageView) findViewById(R.id.match3);
        mImageView3 = new ImageView(this);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        Intent intentResult = getIntent();
        String dogName = intentResult.getStringExtra("resultJson");
        String serverURL1 = "http://222.112.134.57:5008/static/" + dogName + "/match_1.png";
        String serverURL2 = "http://222.112.134.57:5008/static/" + dogName + "/match_2.png";
        String serverURL3 = "http://222.112.134.57:5008/static/" + dogName + "/match_3.png";
        ImageView imageView1 = (ImageView) findViewById(R.id.match1);
        ImageView imageView2 = (ImageView) findViewById(R.id.match2);

        Glide.with(this)
                .load(serverURL1) // image url
                .into(imageView1);
        Glide.with(this)
                .load(serverURL2) // image url
                .into(imageView2);
        Glide.with(this)
                .load(serverURL3) // image url
                .into(mImageView3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        ImageButton button = (ImageButton) findViewById(R.id.match2);

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewpager.addView(mImageView3);
            }
        });

        return (super.onOptionsItemSelected(item));
    }

}
