package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arno.aboutmaterialdesign.R;

public class CustomeBehaviorActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private BehaviorAdapter mAdapter;

    public static void launch(Context context){
        context.startActivity(new Intent(context,CustomeBehaviorActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custome_behavior);

        mRecyclerView = ((RecyclerView) findViewById(R.id.activity_behavior_rv));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new BehaviorAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

    }
}
