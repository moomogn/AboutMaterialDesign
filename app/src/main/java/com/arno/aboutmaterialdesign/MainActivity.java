package com.arno.aboutmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.arno.aboutmaterialdesign.drawerlayout.DrawerLayoutActivity;
import com.arno.aboutmaterialdesign.tablayout.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Arno";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: "+getClass().getSimpleName().toString());
    }

    public void onClick(View view){
        Log.i(TAG, "onClick: ");
        switch (view.getId()) {
            case R.id.activity_main_btn_TabLayout:
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
                break;
            case R.id.activity_main_btn_DrawableLayout:
                startActivity(new Intent(MainActivity.this, DrawerLayoutActivity.class));
                break;
            case R.id.activity_main_btn_TextInputLayout:
                break;
            case R.id.activity_main_btn_FloatingActionButton:
                break;
            case R.id.activity_main_btn_Snackbar:
                break;
            case R.id.activity_main_btn_Toolbar:
                break;
            case R.id.activity_main_btn_CoordinatorLayout:
                break;
            case R.id.activity_main_btn_CollapsingToolbarLayout:
                break;
        }
    }

}
