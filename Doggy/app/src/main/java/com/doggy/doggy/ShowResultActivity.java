package com.doggy.doggy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.net.Uri;

import com.bumptech.glide.Glide;

public class ShowResultActivity extends AppCompatActivity {
    private RelativeLayout mSlider;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private boolean mIsOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_show_result);
        mSlider = findViewById(R.id.slider);
        mImageView2 = findViewById(R.id.match2);
        mImageView3 = new ImageView(this);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        Intent intentResult = getIntent();
        String facesString = intentResult.getStringExtra("face");
        Uri facesUri = Uri.parse(facesString);
        Log.e("bbbbb", facesUri.toString());
        String dogName = intentResult.getStringExtra("resultJson");
        String serverURL1 = "http://222.112.134.57:5008/static/" + dogName + "/match_1.png";
        String serverURL2 = "http://222.112.134.57:5008/static/" + dogName + "/match_2.png";
        String serverURL3 = "http://222.112.134.57:5008/static/" + dogName + "/match_3.png";
        ImageView imageView1 = findViewById(R.id.match1);
        ImageView yourFace = findViewById(R.id.yourFace);
        yourFace.setImageURI(facesUri);

//        yourFace.setScaleType(ImageView.ScaleType.FIT_CENTER);

        Glide.with(this)
                .load(serverURL1) // image url
                .into(imageView1);
        Glide.with(this)
                .load(serverURL2) // image url
                .into(mImageView2);
        Glide.with(this)
                .load(serverURL3) // image url
                .into(mImageView3);

        mImageView2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mIsOpen) {
                    mSlider.addView(mImageView3);
                } else {
                    mSlider.removeAllViews();
                }
                mIsOpen = !mIsOpen;
            }
        });
    }

}
