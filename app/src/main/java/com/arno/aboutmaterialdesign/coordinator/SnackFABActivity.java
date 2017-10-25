package com.arno.aboutmaterialdesign.coordinator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.arno.aboutmaterialdesign.R;

public class SnackFABActivity extends AppCompatActivity {

    private static final String TAG = "SnackFABActivity";

    private View mContainer;
    private FloatingActionButton mFab;

    public static void launch(Context context){
        context.startActivity(new Intent(context,SnackFABActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_fab);

        mContainer = findViewById(R.id.activity_snack_fab_root);

        mFab = ((FloatingActionButton) findViewById(R.id.activity_snack_fabid));
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                Snackbar.make(mContainer,"Snackbar",Snackbar.LENGTH_SHORT)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SnackFABActivity.this, "Action Click", Toast.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(Color.WHITE).show();
            }
        });

    }
}
