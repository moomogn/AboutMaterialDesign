package com.arno.aboutmaterialdesign.toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.arno.aboutmaterialdesign.R;

public class ToolbarTestActivity2 extends AppCompatActivity {

    private static final String TAG = "Arno";

    private Toolbar mToolbar;


    public static void launch(Context context){
        context.startActivity(new Intent(context,ToolbarTestActivity2.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_test2);

        mToolbar = ((Toolbar) findViewById(R.id.activity_test2_toolbar));

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//不显示title

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolbarTestActivity2.this.finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action3, menu);
        return super.onCreateOptionsMenu(menu);
    }
    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
    }
}
