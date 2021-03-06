package com.arno.aboutmaterialdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.arno.aboutmaterialdesign.appbarlayout.AppBarLayoutTestActivity;
import com.arno.aboutmaterialdesign.collapsing.CheesesActivity;
import com.arno.aboutmaterialdesign.coordinator.CoordinatorActivity;
import com.arno.aboutmaterialdesign.drawerlayout.DrawerLayoutActivity;
import com.arno.aboutmaterialdesign.floating.FloatingActionButtonActivity;
import com.arno.aboutmaterialdesign.snackbar.SnackbarActivity;
import com.arno.aboutmaterialdesign.tablayout.TabLayoutActivity;
import com.arno.aboutmaterialdesign.textinput.TextInputActivity;
import com.arno.aboutmaterialdesign.toolbar.ToolbarActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
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
                TextInputActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_FloatingActionButton:
                FloatingActionButtonActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_Snackbar:
                SnackbarActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_Toolbar:
                ToolbarActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_CoordinatorLayout:
                CoordinatorActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_AppBarLayout:
                AppBarLayoutTestActivity.launch(MainActivity.this);
                break;
            case R.id.activity_main_btn_CollapsingToolbarLayout:
                CheesesActivity.launch(MainActivity.this);
                break;
        }
    }

}
