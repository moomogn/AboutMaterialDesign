package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arno.aboutmaterialdesign.R;

import static android.support.design.widget.SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END;

public class BehaviorActivity2 extends AppCompatActivity {
    private static final String TAG = "BehaviorActivity2";
    private TextView mTextView;

    public static void launch(Context context){
        context.startActivity(new Intent(context,BehaviorActivity2.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behavior2);

        mTextView = ((TextView) findViewById(R.id.activity_behavior2_tv));



    }

    @Override
    protected void onResume() {
        super.onResume();
        SwipeDismissBehavior<View> behavior = new SwipeDismissBehavior<>();
        behavior.setSwipeDirection(SWIPE_DIRECTION_START_TO_END);
//        behavior.setDragDismissDistance(0.9f);
        behavior.setStartAlphaSwipeDistance(0.5f);
        behavior.setEndAlphaSwipeDistance(0.9f);
//        behavior.setSensitivity(0.5f);
        behavior.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Log.d(TAG, "onDismiss: ");
            }

            @Override
            public void onDragStateChanged(int state) {
                Log.d(TAG, "onDragStateChanged: ");
            }
        });
        ((CoordinatorLayout.LayoutParams) mTextView.getLayoutParams()).setBehavior(behavior);
    }
}
