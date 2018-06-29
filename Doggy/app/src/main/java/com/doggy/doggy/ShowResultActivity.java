package com.doggy.doggy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ShowResultActivity extends AppCompatActivity {
    private Uri mCroppedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_show_result);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));

        Intent intentResult = getIntent();
        String dogName = intentResult.getStringExtra("resultJson");
        String serverURL1 = "http://222.112.134.57:5008/static/"+dogName+"/match_1.png";
        String serverURL2 = "http://222.112.134.57:5008/static/"+dogName+"/match_2.png";
        String serverURL3 = "http://222.112.134.57:5008/static/"+dogName+"/match_3.png";
        ImageView imageView1 = (ImageView)findViewById(R.id.match1);
        ImageView imageView2 = (ImageView)findViewById(R.id.match2);
//        ImageView imageView3 = (ImageView)findViewById(R.id.match3);
        Glide.with(this)
                .load(serverURL1) // image url
                .into(imageView1);
        Glide.with(this)
                .load(serverURL2) // image url
                .into(imageView2);
//        Glide.with(this)
//                .load(serverURL3) // image url
//                .into(imageView3);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }
}
