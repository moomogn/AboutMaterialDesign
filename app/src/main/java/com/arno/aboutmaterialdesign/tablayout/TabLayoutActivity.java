package com.arno.aboutmaterialdesign.tablayout;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.arno.aboutmaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private static final String TAG = "Arno";
    public static final String KEY_ARGB_FLAG = "key_argb_flag";
    private boolean mArgbFlag;

    private TabLayout tablayout;
    private ViewPager viewpager;

    private List<Fragment> fragments;
    private List<String> titles;
    private View mContainer;

    public static void launch(Context context,boolean argbFlag){
        Intent argbIntent = new Intent(context, TabLayoutActivity.class);
        argbIntent.putExtra(KEY_ARGB_FLAG,argbFlag);
        context.startActivity(argbIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initData();

        initContainer();

        initTablayout();

        initViewPager();

    }

    private void initData() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String title = ((char) ('A' + i)) + "";
            fragments.add(BlankFragment.newInstance(title));
            titles.add(title);
        }

        mArgbFlag = getIntent().getBooleanExtra(KEY_ARGB_FLAG,false);
    }

    private void initContainer() {
        mContainer = findViewById(R.id.activity_tablayout_container);
    }

    /**
     * 简单使用，属性
     */
    private void initTablayout() {
        tablayout = ((TabLayout) findViewById(R.id.activity_tablayout));
        /**
         Tablayout.newTab()                  创建标签
         Tablayout.addTab()                  添加标签
         Tablayout.removeTab()               删除标签
         Tablayout.removeTabAt()             通过索引删除标签
         Tablayout.removeAllTabs()           删除全部标签

         Tablayout.Tab方法
         setText ()                          设置Tab文本内容
         getText ()                          获取Tab文本内容
         setIcon ()                          为Tab添加图标
         getIcon ()                          获取Tab的图标
         setCustomView()                     设置用户自定义的Tab，参数为资源id或者View对象

         Tablayout.getSelectedTabPosition()  获取当前选中的Tab位置
         Tablayout.getTabAt()                根据索引获取Tab
         Tablayout.getTabCount()             获取Tab总数
         */

        tablayout.setSelectedTabIndicatorColor(
                getResources().getColor(R.color.colorPrimary));   //指示器颜色 - app:tabIndicatorColor=""
        tablayout.setSelectedTabIndicatorHeight(10);              //指示器高度 - app:tabIndicatorHeight=""
        tablayout.setTabTextColors(Color.BLACK,                   //Tab 颜色   - app:tabTextColor=""
                getResources().getColor(R.color.colorAccent));    //          - app:tabSelectedTextColor=""
                                                                  //          - app:tabTextAppearance=""      为Tab文本设置样式
        tablayout.setTabMode(TabLayout.MODE_FIXED);               //Tab 模式   - app:tabMode=""
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);          //Tab 对齐   - app:tabGravity=""

    }

    private void initViewPager() {
        viewpager = ((ViewPager) findViewById(R.id.activity_tablayout_viewpager));

        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments == null ? null : fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments == null ? 0 : fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles == null ? "" : titles.get(position);
            }
        });

        if (mArgbFlag) {
            viewpager.addOnPageChangeListener(new PagerChangeListener());
        }

        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: " + getClass().getSimpleName().toString());
    }

    private class PagerChangeListener implements ViewPager.OnPageChangeListener{
        private int[] colors = {Color.parseColor("#e16428"),Color.parseColor("#ffbc2c"),
                Color.parseColor("#86b86b"),Color.parseColor("#878ecd"),Color.parseColor("#9a9b94"),};
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (positionOffset == 0) {
                return;
            }

            //得到 颜色 估值器
            ArgbEvaluator evaluator = new ArgbEvaluator();
            //根据positionOffset得到渐变色
            int evaluate = (int) evaluator.evaluate(positionOffset,colors[position],colors[position+1]);
            mContainer.setBackgroundColor(evaluate);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
