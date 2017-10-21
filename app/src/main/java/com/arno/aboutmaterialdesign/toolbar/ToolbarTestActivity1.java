package com.arno.aboutmaterialdesign.toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.arno.aboutmaterialdesign.R;

public class ToolbarTestActivity1 extends AppCompatActivity {

    private static final String TAG = "Arno";

    private static final int[] res = {R.drawable.ic_bike,R.drawable.ic_bus,R.drawable.ic_taxi,R.drawable.ic_train,R.drawable.ic_plane,};

    private Toolbar mToolbar;
    private ActionMenuView mActionMenuView;
    private ImageView mImageView;

    public static void launch(Context context){
        context.startActivity(new Intent(context,ToolbarTestActivity1.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test1);

        mActionMenuView = ((ActionMenuView) findViewById(R.id.activity_test1_toolbar_actionMenuViewId));
        mActionMenuView.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_action_item1:
                        Log.i(TAG, "onMenuItemClick: item1");
                        Toast.makeText(ToolbarTestActivity1.this, "item1", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[0]);
                        break;
                    case R.id.menu_action_item2:
                        Log.i(TAG, "onMenuItemClick: item2");
                        Toast.makeText(ToolbarTestActivity1.this, "item2", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[1]);
                        break;
                    case R.id.menu_action_item3:
                        Log.i(TAG, "onMenuItemClick: item3");
                        Toast.makeText(ToolbarTestActivity1.this, "item3", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[2]);
                        break;
                    case R.id.menu_action_item4:
                        Log.i(TAG, "onMenuItemClick: item4");
                        Toast.makeText(ToolbarTestActivity1.this, "item4", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[3]);
                        break;
                    case R.id.menu_action_item5:
                        Log.i(TAG, "onMenuItemClick: item5");
                        Toast.makeText(ToolbarTestActivity1.this, "item5", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[4]);
                        break;
                }
                return false;
            }
        });

        mToolbar = ((Toolbar) findViewById(R.id.activity_test1_toolbar));

        setSupportActionBar(mToolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);//不显示title
//        getSupportActionBar().setDisplayHomeAsUpEnabled(false);//不显示NavigationIcon
//        getSupportActionBar().setDisplayShowHomeEnabled(false);//不显示logo

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolbarTestActivity1.this.finish();
            }
        });
        mImageView = ((ImageView) findViewById(R.id.activity_test1_toolbar_img));

//        setupMenuFun2();
    }

    private void setupMenuFun2() {
        // actionMenu 如果使用这个方式，则不能调用 setSupportActionBar
        mToolbar.inflateMenu(R.menu.menu_action2);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_action_item1:
                        Log.i(TAG, "onMenuItemClick: item1");
                        Toast.makeText(ToolbarTestActivity1.this, "item1", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[0]);
                        break;
                    case R.id.menu_action_item2:
                        Log.i(TAG, "onMenuItemClick: item2");
                        Toast.makeText(ToolbarTestActivity1.this, "item2", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[1]);
                        break;
                    case R.id.menu_action_item3:
                        Log.i(TAG, "onMenuItemClick: item3");
                        Toast.makeText(ToolbarTestActivity1.this, "item3", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[2]);
                        break;
                    case R.id.menu_action_item4:
                        Log.i(TAG, "onMenuItemClick: item4");
                        Toast.makeText(ToolbarTestActivity1.this, "item4", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[3]);
                        break;
                    case R.id.menu_action_item5:
                        Log.i(TAG, "onMenuItemClick: item5");
                        Toast.makeText(ToolbarTestActivity1.this, "item5", Toast.LENGTH_SHORT).show();
                        mImageView.setImageResource(res[4]);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mToolbar.setTitle(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        getMenuInflater().inflate(R.menu.menu_action2, mActionMenuView.getMenu());
        return super.onCreateOptionsMenu(mActionMenuView.getMenu());
    }

}
