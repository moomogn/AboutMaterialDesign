package com.arno.aboutmaterialdesign.coordinator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.arno.aboutmaterialdesign.R;
import com.arno.aboutmaterialdesign.coordinator.behavior.BehaviorActivity;
import com.arno.aboutmaterialdesign.coordinator.behavior.BehaviorActivity2;
import com.arno.aboutmaterialdesign.coordinator.behavior.CustomeBehaviorActivity;

public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener {


    private Button mBtn_sf;
    private Button mBtn_ob;
    private Button mBtn_ob2;
    private Button mBtn_cb;

    public static void launch(Context context){
        context.startActivity(new Intent(context,CoordinatorActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        mBtn_sf = ((Button) findViewById(R.id.activity_coordinator_btn1));
        mBtn_ob = ((Button) findViewById(R.id.activity_coordinator_btn2));
        mBtn_ob2 = ((Button) findViewById(R.id.activity_coordinator_btn3));
        mBtn_cb = ((Button) findViewById(R.id.activity_coordinator_btn4));

        mBtn_sf.setOnClickListener(this);
        mBtn_ob.setOnClickListener(this);
        mBtn_ob2.setOnClickListener(this);
        mBtn_cb.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_coordinator_btn1:
                SnackFABActivity.launch(CoordinatorActivity.this);
                break;
            case R.id.activity_coordinator_btn2:
                BehaviorActivity.launch(CoordinatorActivity.this);
                break;
            case R.id.activity_coordinator_btn3:
                BehaviorActivity2.launch(CoordinatorActivity.this);
                break;
            case R.id.activity_coordinator_btn4:
                CustomeBehaviorActivity.launch(CoordinatorActivity.this);
                break;
        }
    }
}
