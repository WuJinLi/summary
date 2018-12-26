package com.wjl.test;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.wjl.test.arouter.ArouterActivity;
import com.wjl.test.eventbus.EventBusAcceptActivity;
import com.wjl.test.eventbus.EventBusPostActivity;
import com.wjl.test.mvvm.view.MvvmActivity;
import com.wjl.test.otto.OttoAccecptActivity;
import com.wjl.test.view.CoustomViewActivity;

import java.util.ArrayList;
import java.util.List;


@Route(path = "/test/main")
public class MainActivity extends AppCompatActivity {


    private RecyclerView lv;
    LvAdapter adapter;
    private List<ItemBean> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new LvAdapter(this, list);
        lv = findViewById(R.id.lv);

        lv.setLayoutManager(new LinearLayoutManager(this));

        lv.setAdapter(adapter);


        getData();
        adapter.setList(list);


        findViewById(R.id.btn_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getResult();
                startActivity(new Intent(MainActivity.this, EventBusAcceptActivity.class));
            }
        });


        findViewById(R.id.btn_event_bus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EventBusPostActivity.class));
            }
        });


        findViewById(R.id.btn_otto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OttoAccecptActivity.class));
            }
        });


        findViewById(R.id.btn_mvvm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MvvmActivity.class));
            }
        });


        findViewById(R.id.btn_design).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CoustomViewActivity.class));
            }
        });



        findViewById(R.id.btn_arouter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test/acarouter").navigation();
            }
        });

        findViewById(R.id.btn_interaction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build("/test/interaction").navigation();
            }
        });
    }


    public void getData() {

        for (int i = 0; i < 14; i++) {
            ItemBean itemBean = new ItemBean();

            if (i % 2 == 0) {
                itemBean.setChecked(false);
            } else {
                itemBean.setChecked(true);
            }

            itemBean.setContent(i + "");

            list.add(itemBean);
        }
    }


    public void getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        List<ItemBean> data = adapter.getChooesData();

        for (ItemBean itemBean : data) {
            if (itemBean.isChecked()) {
                stringBuilder.append(itemBean.getContent());
            }
        }


        Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
    }
}

