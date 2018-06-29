package com.doggy.doggy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class AdjustPicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_adjust_pic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        // TODO SEJIN: Get image from TakePicActivity and put it in facePictureView.
//        Uri facePictureUri = Uri.parse("https://raw.githubusercontent.com/42deSix/Images/master/a_cat_hitting_a_dog.jpg");
        CropImageView cropImageView = findViewById(R.id.cropImageView);
//        cropImageView.setImageUriAsync(facePictureUri);

        // start picker to get image for cropping and then use the image in cropping activity
        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(this);

        // start cropping activity for pre-acquired image saved on the device
//        CropImage.activity(facePictureUri)
//                .start(this);

        Button adjustButton = findViewById(R.id.adjustButton);
        adjustButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(AdjustPicActivity.this, HttpSndRcvActivity.class));
                    }
                }
        );


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                Intent intent = new Intent(this, HttpSndRcvActivity.class);
                String uri = resultUri.toString();
                intent.putExtra("imageUri",uri);
                startActivity(intent);
                ImageView facePictureImageView = findViewById(R.id.facePicture);
                facePictureImageView.setImageURI(resultUri);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
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
