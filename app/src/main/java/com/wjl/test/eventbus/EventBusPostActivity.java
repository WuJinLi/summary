package com.wjl.test.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wjl.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventBusPostActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_post, btn_jump;
    private TextView tv_post_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_event_bus_post);
        EventBus.getDefault().register(this);
        btn_post = findViewById(R.id.btn_post);
        btn_jump = findViewById(R.id.btn_jump);
        tv_post_content = findViewById(R.id.tv_post_content);


        btn_post.setOnClickListener(this);
        btn_jump.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_post:

                break;
            case R.id.btn_jump:
                post();
                break;
            default:
                break;
        }
    }

    private void post() {


        startActivity(new Intent(EventBusPostActivity.this, EventBusAcceptActivity.class));
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handEvent(EventInfoEnity eventInfoEnity) {
        tv_post_content.setText(new Gson().toJson(eventInfoEnity));
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
