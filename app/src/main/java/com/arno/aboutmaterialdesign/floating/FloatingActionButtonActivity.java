package com.arno.aboutmaterialdesign.floating;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.arno.aboutmaterialdesign.R;

public class FloatingActionButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "arno";
    private FloatingActionButton mFab;

    public static void launch(Context context){
        context.startActivity(new Intent(context,FloatingActionButtonActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        mFab = ((FloatingActionButton) findViewById(R.id.activity_floating_action_button_fab));
        mFab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_floating_action_button_fab:
                mFab.setSelected(!mFab.isSelected());
//                mFab.setImageBitmap(BitmapFactory.decodeResource(getResources(),mFab.isSelected()?R.drawable.ic_floating_x:R.drawable.ic_floating_correct));
                mFab.setImageResource(mFab.isSelected()?R.drawable.ic_floating_x:R.drawable.ic_floating_correct);
                break;
            default:
                break;
        }
    }
}
