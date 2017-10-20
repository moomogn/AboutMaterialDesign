package com.arno.aboutmaterialdesign.toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.arno.aboutmaterialdesign.R;

import static android.widget.Toast.makeText;

public class ToolbarActivity extends AppCompatActivity {

    private static final String TAG = "Arno";

    private Toolbar mToolbar;

    public static void launch(Context context){
        context.startActivity(new Intent(context,ToolbarActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        mToolbar = ((Toolbar) findViewById(R.id.activity_toolbar));

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(ToolbarActivity.this, "NavigationIcon Click", Toast.LENGTH_SHORT).show();
            }
        });

        setSupportActionBar(mToolbar);

        mToolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more));//更改右上角图标

        /**
         * 自定义 toolbar 布局，具体需要看看 Toolbar.LayoutParams 的源码，查看它的布局方法
         */
//        View addView = LayoutInflater.from(mToolbar.getContext()).inflate(R.layout.toolbar_custom_tv, null);
//        Toolbar.LayoutParams p = new Toolbar.LayoutParams( Toolbar.LayoutParams.WRAP_CONTENT,Toolbar.LayoutParams.WRAP_CONTENT, Gravity.RIGHT);
//        addView.setLayoutParams(p);
//        mToolbar.addView(addView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_item1:
                Log.i(TAG, "onMenuItemClick: like");
                makeText(ToolbarActivity.this, "like", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_action_item2:
                Log.i(TAG, "onMenuItemClick: share");
                makeText(ToolbarActivity.this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_action_item3:
                Log.i(TAG, "onMenuItemClick: setup");
                makeText(ToolbarActivity.this, "setup", Toast.LENGTH_SHORT).show();
//                item.getIcon().setColorFilter(ContextCompat.getColor(this,android.R.color.darker_gray), PorterDuff.Mode.MULTIPLY);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
                Log.i(TAG, "onMenuOpened: className=="+menu.getClass().getSimpleName());
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                ((MenuBuilder) menu).setOptionalIconsVisible(true);
            }
        }
        return super.onMenuOpened(featureId, menu);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.activity_toolbar_btn1:
                ToolbarTestActivity1.launch(ToolbarActivity.this);
                break;
            case R.id.activity_toolbar_btn2:
                ToolbarTestActivity2.launch(ToolbarActivity.this);
                break;
            default:
                break;
        }
    }
}
