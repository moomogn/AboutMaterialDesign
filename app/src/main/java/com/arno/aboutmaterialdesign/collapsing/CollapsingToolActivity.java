package com.arno.aboutmaterialdesign.collapsing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arno.aboutmaterialdesign.R;

public class CollapsingToolActivity extends AppCompatActivity {


    public static void launch(Context context){
        context.startActivity(new Intent(context,CollapsingToolActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_tool);
    }
}
