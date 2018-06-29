package com.doggy.doggy;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpSndRcvActivity extends AppCompatActivity {
    private Uri mCroppedImageUri;
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/jpeg");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_http_snd_rcv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
        final TextView httpTextViewResult = findViewById(R.id.textView);

//        mCroppedImageUri = getIntent().getParcelableExtra("croppedImageUri");
//        Uri resultUri = Uri.parse(mCroppedImageUri.toString());

        final Intent intentResult = new Intent(getApplicationContext(), ShowResultActivity.class);
        Uri croppedImageUri = getIntent().getParcelableExtra("croppedImageUri");
        Uri resultUri = Uri.parse(croppedImageUri.toString());

        File imageFile = new File(resultUri.getPath());
        httpTextViewResult.setText("나와 닯은 개를 매칭 중입니다");
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(1000, TimeUnit.SECONDS)
                .writeTimeout(1000, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("image", "image.jpeg", RequestBody.create(MEDIA_TYPE_PNG, imageFile))
                .build();
        Request request = new Request.Builder()
                .url("http://222.112.134.57:5008")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpTextViewResult.setText("애플리케이션을 재시작 해주세요.");
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()) {

                    final String myResponse = response.body().string();
                    System.out.print(myResponse);
                    HttpSndRcvActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("매칭 완료!");
                                httpTextViewResult.setText("매칭 완료");
                        }
                    });
                    intentResult.putExtra("resultJson",myResponse);
                }

//                Intent intent = new Intent(HttpSndRcvActivity.this, ShowResultActivity.class);
//                intent.putExtra("croppedImageUri", mCroppedImageUri.toString());
//                startActivity(intent);
//
//                startActivity(new Intent(HttpSndRcvActivity.this, ShowResultActivity.class));
                startActivity(intentResult);
            }
        });
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
