package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Arno on 2017/10/24.
 *
 * 实现上滑滚出，下滑跟进的效果
 */
public class TestScrollBehavior2 extends CoordinatorLayout.Behavior<View>{
    private static final String TAG = "TestScrollBehavior2";
    private int offset = 0;
    /**
     * 必须重写这个方法
     * @param context
     * @param attrs
     */
    public TestScrollBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY) {
        return true;
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        int temp = offset;
        int top = offset - dyConsumed;

        //上滑
        if (dyConsumed > 0) {
            temp = Math.max(top,-child.getHeight());
        }

        //下滑
        if (dyConsumed < 0) {
            temp = Math.min(top,0);
        }

        child.offsetTopAndBottom(temp - offset);
        offset = temp;
    }

}
