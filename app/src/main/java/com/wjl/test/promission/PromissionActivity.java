package com.wjl.test.promission;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wjl.test.R;

public class PromissionActivity extends AppCompatActivity {

    Button btn_call;
    Context mContext;
    static final int REQUEST_CODE = 0x01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_promission);
        mContext = this;
        findViewById(R.id.btn_call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callphone();
            }
        });
    }




    public void callphone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:"+"10086");
        intent.setData(data);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager
                .PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);
        }else {
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        if (requestCode==REQUEST_CODE){

        }
    }
}
