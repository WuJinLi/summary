package com.wjl.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * author: WuJinLi
 * time  : 2018/11/8
 * desc  :
 */
public class LvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ItemBean> list;
    private Context context;
    private LayoutInflater inflater;
    private ViewHolder holder;


    public LvAdapter(Context context, List<ItemBean> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View root = inflater.inflate(R.layout.ly_item, viewGroup, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
        final ItemBean itemBean = list.get(position);
        if (viewHolder instanceof ViewHolder) {
            holder = (ViewHolder) viewHolder;


            ((ViewHolder) viewHolder).et_text.setText(itemBean.getContent());

            ((ViewHolder) viewHolder).cb.setChecked(itemBean.isChecked());


            ((ViewHolder) viewHolder).cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        ((ViewHolder) viewHolder).ll_toot.clearFocus();
                        ((ViewHolder) viewHolder).et_text.setFocusable(true);
                        ((ViewHolder) viewHolder).et_text.setFocusableInTouchMode(true);
                    } else {
                        ((ViewHolder) viewHolder).et_text.clearFocus();
                    }
                    itemBean.setChecked(isChecked);
                }
            });


            ((ViewHolder) viewHolder).et_text.setTag(position);


            if (((ViewHolder) viewHolder).et_text.hasFocus()) {
                if (!((ViewHolder) viewHolder).cb.isChecked()) {
                    ((ViewHolder) viewHolder).cb.setChecked(true);
                    itemBean.setChecked(true);
                }
            }


            ((ViewHolder) viewHolder).et_text.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        if (!((ViewHolder) viewHolder).cb.isChecked()) {
                            ((ViewHolder) viewHolder).cb.setChecked(true);
                        }
                        ((ViewHolder) viewHolder).et_text.setSelection(((ViewHolder) viewHolder).et_text.getText()
                                .length());
                    }
                }
            });

            ((ViewHolder) viewHolder).et_text.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if ((Integer) ((ViewHolder) viewHolder).et_text.getTag() == position && ((ViewHolder) viewHolder)
                            .et_text.hasFocus()) {
                        if (!TextUtils.isEmpty(s.toString())) {
                            itemBean.setContent(s.toString());
                        } else {
                            itemBean.setContent("0");
                        }
                    }
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout ll_toot;
        public CheckBox cb;
        public EditText et_text;
        public Button btn_go;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_toot = itemView.findViewById(R.id.ll_toot);
            cb = itemView.findViewById(R.id.cb);
            et_text = itemView.findViewById(R.id.et_text);
            btn_go = itemView.findViewById(R.id.btn_go);
        }
    }


    public void setList(List<ItemBean> list) {
        this.list = list;
    }


    public List<ItemBean> getChooesData() {
        List<ItemBean> items = new ArrayList<>();

        for (ItemBean itemBean : list) {
            if (itemBean.isChecked()) {
                items.add(itemBean);
            }
        }


        return items;

    }
}
