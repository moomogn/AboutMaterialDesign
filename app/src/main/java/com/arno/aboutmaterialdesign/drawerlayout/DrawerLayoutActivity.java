package com.arno.aboutmaterialdesign.drawerlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arno.aboutmaterialdesign.R;

public class DrawerLayoutActivity extends AppCompatActivity {

    private static final String TAG = "Arno";
    private NavigationView mNavigationView;
    private boolean visibleFlag = true;
    private Button mBtn;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        initDrawer();

        initContent();

    }

    private void initContent() {
        mBtn = ((Button) findViewById(R.id.content_drawer_btn));
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
                    mDrawerLayout.closeDrawer(mNavigationView);
                }else{
                    mDrawerLayout.openDrawer(mNavigationView);
                }
            }
        });
    }

    private void initDrawer() {
        mDrawerLayout = ((DrawerLayout) findViewById(R.id.activity_drawer_drawerlayoutId));
        mNavigationView = ((NavigationView) findViewById(R.id.activity_drawer_nav));

        //滚动条
        mNavigationView.getChildAt(0).setVerticalScrollBarEnabled(false);

        //nav menu item color
        mNavigationView.setItemIconTintList(null);
        mNavigationView.setItemTextColor(getResources().getColorStateList(R.color.selector_nav_menu_item));
        mNavigationView.setItemTextAppearance(R.style.main_nav_menu_item_text_appearance);

        //click event
        mNavigationView.setNavigationItemSelectedListener(new CusNavigationItemStateListener());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: "+getClass().getSimpleName().toString());
    }

    private class CusNavigationItemStateListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_drawer_item_city:
                    Log.i(TAG, "onNavigationItemSelected: 选择城市");
                    Toast.makeText(DrawerLayoutActivity.this, "选择城市", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_drawer_item_xxx:
                    Log.i(TAG, "onNavigationItemSelected: 隐藏/显示");
                    visibleFlag = !visibleFlag;
                    Toast.makeText(DrawerLayoutActivity.this, visibleFlag?"显示":"隐藏", Toast.LENGTH_SHORT).show();
                    mNavigationView.getMenu().setGroupVisible(R.id.menu_drawer_group2,visibleFlag);
                    break;
                case R.id.menu_drawer_item_vip:
                    Log.i(TAG, "onNavigationItemSelected: vip");
                    Toast.makeText(DrawerLayoutActivity.this, "vip", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_drawer_item_bookin:
                    Log.i(TAG, "onNavigationItemSelected: 签到");
                    Toast.makeText(DrawerLayoutActivity.this, "签到", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.menu_drawer_item_set:
                    Log.i(TAG, "onNavigationItemSelected: 设置");
                    Toast.makeText(DrawerLayoutActivity.this, "设置", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            return false;
        }
    }
}
