//package com.wjl.test;
//
//import android.content.Context;
//import android.support.annotation.Nullable;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.widget.EditText;
//
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.chad.library.adapter.base.BaseViewHolder;
//
//import java.util.List;
//
///**
// * author: WuJinLi
// * time  : 2018/11/8
// * desc  :
// */
//public class MyAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {
//    private Context context;
//
//    public MyAdapter(int layoutResId, @Nullable List<ItemBean> data, Context context) {
//        super(layoutResId, data);
//        this.context=context;
//    }
//
//    @Override
//    protected void convert(BaseViewHolder helper, final ItemBean item) {
//        helper.setText(R.id.et_text, item.getContent());
//
//        if (item.isChecked()){
//            helper.getView(R.id.b).setBackground(context.getResources().getDrawable(R.drawable.open));
//        }else {
//            helper.getView(R.id.btn_cb).setBackground(context.getResources().getDrawable(R.drawable.close));
//        }
//
//        helper.addOnClickListener(R.id.btn_cb);
//        helper.addOnClickListener(R.id.btn_go);
//
//
//        final EditText editText=helper.getView(R.id.et_text);
//
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                item.setContent(s.toString());
//            }
//        });
//
//    }
//
//
//
//}
