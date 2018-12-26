package com.wjl.test.otto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.otto.Subscribe;
import com.wjl.test.R;

public class OttoAccecptActivity extends AppCompatActivity {

    private Button btn_go_post;
    private TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otto_accecpt);
        OttoBus.getInstance().register(this);
        btn_go_post=findViewById(R.id.btn_go_post);
        tv_show=findViewById(R.id.tv_show);



        btn_go_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OttoAccecptActivity.this,OttoPostActivity.class));
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    }





    @Subscribe
    public void accept(OttoInfoEnity ottoInfoEnity){
        tv_show.setText(ottoInfoEnity.getContent());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        OttoBus.getInstance().unregister(this);
    }
}
