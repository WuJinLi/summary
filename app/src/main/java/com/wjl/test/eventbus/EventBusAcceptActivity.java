package com.wjl.test.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.wjl.test.R;

import org.greenrobot.eventbus.EventBus;

public class EventBusAcceptActivity extends AppCompatActivity {


    private Button tv_accetp_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_event_bus_accept);
        tv_accetp_info = findViewById(R.id.tv_accetp_info);




        tv_accetp_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventInfoEnity eventInfoEnity = new EventInfoEnity("zhangsan", 12, "femal", "beijing");
                EventBus.getDefault().post(eventInfoEnity);
                Toast.makeText(EventBusAcceptActivity.this,new Gson().toJson(eventInfoEnity),Toast.LENGTH_SHORT).show();
            }
        });


    }






}
