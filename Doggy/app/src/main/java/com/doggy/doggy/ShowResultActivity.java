package com.doggy.doggy;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

public class ShowResultActivity extends FragmentActivity{

    private ViewPager mViepager;
    private PagerAdapter mpageadpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        mViepager = (ViewPager) findViewById(R.id.viewpager); //뷰 페이저



        Button button1 = (Button) findViewById(R.id.button1) ;

        button1.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                    mViepager.setBackgroundResource(R.drawable.load_4);

            } });

    }




}
