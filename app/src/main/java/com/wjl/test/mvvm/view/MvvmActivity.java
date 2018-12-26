package com.wjl.test.mvvm.view;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.wjl.test.R;
import com.wjl.test.databinding.AcMvvmBinding;
import com.wjl.test.mvvm.model.User;

/**
 * author: WuJinLi
 * time  : 2018/12/19
 * desc  :
 */
public class MvvmActivity extends AppCompatActivity {

    User user=new User("sfsaf","2");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AcMvvmBinding acMvvmBinding = DataBindingUtil.setContentView(this, R.layout.ac_mvvm);
//        TextView textView =findViewById(R.id.tv_show);

        acMvvmBinding.setUser(user);

//        user.setName("fsafsdfsd");
         acMvvmBinding.tvShow.setText("asdfsfdsf");

    }
}
