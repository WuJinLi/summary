package com.wjl.test.design;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

import com.wjl.test.R;

public class DesignActivity extends AppCompatActivity {

    private Toolbar tb_topbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_design);
        tb_topbar = findViewById(R.id.tb_topbar);

        setSupportActionBar(tb_topbar);


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_b);


        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(vibrantSwatch.getRgb()));
            }
        });

    }
}
