package com.arno.aboutmaterialdesign.snackbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arno.aboutmaterialdesign.R;

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn_1;
    private Button mBtn_2;
    private View mContainer;

    public static void launch(Context context){
        context.startActivity(new Intent(context,SnackbarActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        mContainer = findViewById(R.id.activity_snackbar_container);

        mBtn_1 = ((Button) findViewById(R.id.activity_snackbar_button_1));
        mBtn_2 = ((Button) findViewById(R.id.activity_snackbar_button_2));

        mBtn_1.setOnClickListener(this);
        mBtn_2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_snackbar_button_1:
                Snackbar.make(mContainer,"简单使用",Snackbar.LENGTH_SHORT).setAction(("action"), new View.OnClickListener() {
                    @Override
                   public void onClick(View v) {
                        Toast.makeText(SnackbarActivity.this, "简单使用 action 点击", Toast.LENGTH_SHORT).show();
                    }
                }).show();
                break;
            case R.id.activity_snackbar_button_2:
                Snackbar snackbar = Snackbar.make(mContainer, "自定义 action ", Snackbar.LENGTH_SHORT).setAction("action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(SnackbarActivity.this, "自定义 action 点击", Toast.LENGTH_SHORT).show();
                    }
                });

                Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
                View addView = LayoutInflater.from(layout.getContext()).inflate(R.layout.snack_custom_img, null);
                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams( LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                p.gravity= Gravity.CENTER_VERTICAL;
                layout.addView(addView);
                snackbar.show();

                break;
        }
    }
}
