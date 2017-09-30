package com.arno.aboutmaterialdesign;

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
                TabLayoutActivity.launch(MainActivity.this,false);
                break;
            case R.id.activity_main_btn_DrawableLayout:
                DrawerLayoutActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_ArgbEvaluator:
                TabLayoutActivity.launch(MainActivity.this,true);
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
