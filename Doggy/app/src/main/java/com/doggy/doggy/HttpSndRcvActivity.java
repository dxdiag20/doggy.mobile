package com.doggy.doggy;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpSndRcvActivity extends AppCompatActivity {
    private static final String IMGUR_CLIENT_ID = "9199fdef135c122";
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_snd_rcv);
        Uri croppedImageUri = getIntent().getParcelableExtra("croppedImageUri");
        // TODO: Send croppedImageUri to the server

        final TextView httpTextViewResult = findViewById(R.id.textView);
        httpTextViewResult.setText("server on");
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", "logo")
                .addFormDataPart("image", "logo-square.png",
                        RequestBody.create(MEDIA_TYPE_PNG, new File("website/static/logo-square.png")))
                .build();
//        Request request = new Request.Builder()
//                .url("http://222.112.134.57:5008")
//                .build();
        Request request = new Request.Builder()
                .url("http://222.112.134.57:5008")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                httpTextViewResult.setText("fail");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //httpTextViewResult.setText("onReponse");
                if(response.isSuccessful()) {

                    final String myResponse = response.body().string();

                    HttpSndRcvActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            httpTextViewResult.setText(myResponse);
                        }
                    });
                }
            }
        });
    }
}
