package com.arno.aboutmaterialdesign.appbarlayout;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.arno.aboutmaterialdesign.R;

public class AppBarLayoutTestActivity extends AppCompatActivity {
    private static final String TAG = "AppBarLayoutTestActivit";
    private NestedScrollView mNestedScrollView;
    private View mHeadBgContainer;
    private ImageView mIv_icon;
    private ImageView mIv_iconExtra;
    private TextView mTxt_nickName;
    private AppBarLayout mAppBarLayout;

    private ScrollInfoHolder scrollInfoHolder;
    private boolean ICON_EXTRA_SHOW_FLAG = true;

    public static void launch(Context context) {
        context.startActivity(new Intent(context, AppBarLayoutTestActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout_test);

//        scrollInfoHolder = new ScrollInfoHolder(this);
//
//        mNestedScrollView = ((NestedScrollView) findViewById(R.id.activity_app_bar_layout_nestedscrollview));
//
//        mHeadBgContainer = findViewById(R.id.activity_app_bar_layout_bg_container);
//        mIv_icon = ((ImageView) findViewById(R.id.activity_app_bar_layout_icon));
//        mIv_iconExtra = ((ImageView) findViewById(R.id.activity_app_bar_layout_icon_extra));
//        mTxt_nickName = ((TextView) findViewById(R.id.activity_app_bar_layout_nickname_tv));
//
//        mAppBarLayout = ((AppBarLayout) findViewById(R.id.activity_app_bar_layout));
//        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollInfoHolder.scrollDown_level2()) {// -200 --> -100
//                    iconAnim_moveX(verticalOffset);
//                }
//
//                if (scrollInfoHolder.scrollUp_level1()) {// -100 --> -200
//                    iconAnim_moveX(verticalOffset);
//                    ValueAnimator animation = ValueAnimator.ofFloat(1f, 0f);
//                    if (ICON_EXTRA_SHOW_FLAG) {// 大图标是否已经显示
//                        ICON_EXTRA_SHOW_FLAG = !ICON_EXTRA_SHOW_FLAG;
//                        iconAnim_alphaStart(animation);
//                    }
//                }
//
//                if (scrollInfoHolder.scrollDown_level1()) {// -100 --> 0
//                    ValueAnimator animation = ValueAnimator.ofFloat(0f, 1f);
//                    if (!ICON_EXTRA_SHOW_FLAG) {// 大图标是否已经显示
//                        ICON_EXTRA_SHOW_FLAG = !ICON_EXTRA_SHOW_FLAG;
//                        iconAnim_alphaStart(animation);
//                    }
//                }
//
//                scrollInfoHolder.onOffsetChanged(verticalOffset);
//            }
//        });

    }

    private void iconAnim_alphaStart(ValueAnimator animation) {
        animation.setDuration(500);
        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = (float) animation.getAnimatedValue();
                mIv_iconExtra.setAlpha(fraction);
                mIv_icon.setAlpha(1f - fraction);
            }
        });
        animation.setInterpolator(new LinearInterpolator());
        animation.start();
    }

    private void iconAnim_moveX(int verticalOffset) {
        float transitionX = 0;
        int width_screen = getResources().getDisplayMetrics().widthPixels;
        float width_nickname = mTxt_nickName.getPaint().measureText(mTxt_nickName.getText().toString());
        float transitionXTotal = (width_screen - width_nickname) / 2 - dip2px(this, 30);
        float transitionYTotal = -verticalOffset - dip2px(AppBarLayoutTestActivity.this, 100);
        transitionX = transitionXTotal * (-transitionYTotal / dip2px(AppBarLayoutTestActivity.this, 130));

        ViewCompat.setTranslationX(
                mTxt_nickName, transitionX
        );
        ViewCompat.setTranslationX(
                mIv_icon, transitionX
        );
    }

    static class ScrollInfoHolder {
        private Context context;

        public static final int SCROLL_DOWN = 0;
        public static final int SCROLL_UP = 1;

        public static int mDirection = -1;
        public static int mOldOffset = 0;
        public static int mNewOffset = 0;

        private int level_1;
        private int level_2;


        public ScrollInfoHolder(Context context) {
            this.context = context;
            level_1 = dip2px(context, -100);
            level_2 = dip2px(context, -200);
            Log.i(TAG, "ScrollInfo: level_1==" + level_1 + ",level_2==" + level_2);
        }

        public void onOffsetChanged(int verticalOffset) {
            mOldOffset = mNewOffset;
            mNewOffset = verticalOffset;
            if (mNewOffset != 0) {
                mDirection = mNewOffset > mOldOffset ? SCROLL_DOWN : SCROLL_UP;
            }
        }

        public boolean scrollDown_level1() {
            return mDirection != -1 && mNewOffset > level_1 && mDirection == SCROLL_DOWN;
        }

        public boolean scrollDown_level2() {
            return mDirection != -1 && level_1 > mNewOffset && mNewOffset > level_2 && mDirection == SCROLL_DOWN;
        }

        public boolean scrollUp_level1() {
            return mDirection != -1 && level_1 > mNewOffset && mNewOffset > level_2 && mDirection == SCROLL_UP;
        }

    }

    private static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
