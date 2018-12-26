package com.wjl.test.otto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.squareup.otto.Produce;
import com.wjl.test.R;

public class OttoPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_post);

        OttoBus.getInstance().register(this);



        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }







    @Produce
    public OttoInfoEnity post(){
        OttoInfoEnity ottoInfoEnity=new OttoInfoEnity();

        ottoInfoEnity.setContent("otto");

        return ottoInfoEnity;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }
}
