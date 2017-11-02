package com.arno.aboutmaterialdesign.appbarlayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arno.aboutmaterialdesign.R;

public class AppBarLayoutActivity extends AppCompatActivity {

    public static void launch(Context context){
        context.startActivity(new Intent(context,AppBarLayoutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);
    }
}
