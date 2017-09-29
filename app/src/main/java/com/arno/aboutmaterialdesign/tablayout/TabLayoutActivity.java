package com.arno.aboutmaterialdesign.tablayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arno.aboutmaterialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {
    private static final String TAG = "Arno";

    private TabLayout tablayout;
    private ViewPager viewpager;

    private List<Fragment> fragments;
    private List<String> titles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        initData();

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

        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: "+getClass().getSimpleName().toString());
    }

}
