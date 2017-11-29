package com.example.user.okhttp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private OkHttpClient client = new OkHttpClient();
    private String url = "http://172.104.110.249/api/Login";
    private Request request;
    private EditText edit1;
    private EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText)findViewById(R.id.editText1);
        edit2=(EditText)findViewById(R.id.editText2);
        Button btn1 = (Button)findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login2();
            }
        });


    }
    private void login2(){

        RequestBody body = new FormBody.Builder()
                .add("user_account", edit1.getText().toString())      //.add("鍵", "值")
                .add("user_password", edit2.getText().toString())
                .build();

        OkHttpManager.postEnqueueAsync(url, body, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson = new Gson();
                JsonPara jsonPara = gson.fromJson(result, JsonPara.class);
                Log.d("OkHttp Success", jsonPara.getSuccess());
                Log.d("OkHttp Message", jsonPara.getMessage());
                Log.d("OkHttp token", jsonPara.getToken());
            }
        });
    }

}
