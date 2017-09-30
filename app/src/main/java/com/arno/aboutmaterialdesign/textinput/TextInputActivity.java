package com.arno.aboutmaterialdesign.textinput;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.arno.aboutmaterialdesign.R;

/**
 * |属性	|说明|
 |:--|:--|
 |app:Theme	|设置下划线或其他的颜色属性
 |android.support.design:counterEnabled	                    |是否显示计数器
 |android.support.design:counterMaxLength	                |设置计数器的最大值,与counterEnabled同时使用
 |android.support.design:counterTextAppearance	            |计数器的字体样式
 |android.support.design:counterOverflowTextAppearance	    |输入字符大于我们限定个数字符时的字体样式
 |android.support.design:errorEnabled	                    |是否显示错误信息
 |android.support.design:errorTextAppearance	            |错误信息的字体样式
 |android.support.design:hintAnimationEnabled	            |是否显示hint的动画,默认true
 |android.support.design:hintEnabled	                    |是否使用hint属性,默认true
 |android.support.design:hintTextAppearance 	            |设置hint的文字样式(指运行动画效果之后的样式)
 |android.support.design:passwordToggleDrawable	            |设置密码开关Drawable图片,于passwordToggleEnabled同时使用
 |android.support.design:passwordToggleEnabled	            |是否显示密码开关图片,需要EditText设置inputType
 |android.support.design:passwordToggleTint	                |设置密码开关图片颜色
 |android.support.design:passwordToggleTintMode	            |设置密码开关图片(混合颜色模式),与passwordToggleTint同时使用
 */

public class TextInputActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Arno";
    public static final int ACCOUNT_MAX_SIZE = 6;
    public static final int PASSWORD_MAX_SIZE = 6;

    private TextInputLayout mTextLayout_account;
    private TextInputEditText mEditText_account;
    private TextInputLayout mTextLayout_password;
    private TextInputEditText mEditText_password;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, TextInputActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        initTextLayout_account();

        initTextLayout_password();

        initBtn();

    }

    private void initTextLayout_account() {
        mTextLayout_account = (TextInputLayout) findViewById(R.id.activity_textinput_account);
        mTextLayout_account.setCounterMaxLength(ACCOUNT_MAX_SIZE);
        mEditText_account = ((TextInputEditText) findViewById(R.id.activity_text_input_edit_account));
        mEditText_account.addTextChangedListener(new TextWatcher() {
            private int mDelta = -1;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                mTextLayout_account.setErrorEnabled(false);

                boolean bIncrease = after == 1;
                int delta = s.length() + after - ACCOUNT_MAX_SIZE;
                if (bIncrease && delta > 0) {
                    mDelta = delta;
                } else {
                    mDelta = -1;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mDelta>=0) {
                    mEditText_account.setText(s.subSequence(0, s.length() - mDelta));
                    mEditText_account.setSelection(ACCOUNT_MAX_SIZE);
                }
            }
        });
    }

    private void initTextLayout_password() {
        mTextLayout_password = ((TextInputLayout) findViewById(R.id.activity_textinput_password));
        mTextLayout_password.setCounterMaxLength(PASSWORD_MAX_SIZE);
        mEditText_password = ((TextInputEditText) findViewById(R.id.activity_text_input_edit_pwd));
        mEditText_password.addTextChangedListener(new TextWatcher() {
            private int mDelta = -1;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                mTextLayout_password.setErrorEnabled(false);

                boolean bIncrease = after == 1;
                int delta = s.length() + after - PASSWORD_MAX_SIZE;
                if (bIncrease && delta > 0) {
                    mDelta = delta;
                } else {
                    mDelta = -1;
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (mDelta>=0) {
                    mEditText_password.setText(s.subSequence(0, s.length() - mDelta));
                    mEditText_password.setSelection(PASSWORD_MAX_SIZE);
                }
            }
        });
    }

    private void initBtn() {
        findViewById(R.id.activity_text_input_btn_confirm).setOnClickListener(this);
        findViewById(R.id.activity_text_input_btn_register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_text_input_btn_confirm:
                Toast.makeText(TextInputActivity.this, "登陆", Toast.LENGTH_SHORT).show();
                if (mTextLayout_account != null) {
                    mTextLayout_account.setErrorEnabled(true);
                    mTextLayout_account.setError("账户名或密码错误");
                }
                if (mTextLayout_password != null) {
                    mTextLayout_password.setErrorEnabled(true);
                    mTextLayout_password.setError("账户名或密码错误");
                }
                break;
            case R.id.activity_text_input_btn_register:
                Toast.makeText(TextInputActivity.this, "注册", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
