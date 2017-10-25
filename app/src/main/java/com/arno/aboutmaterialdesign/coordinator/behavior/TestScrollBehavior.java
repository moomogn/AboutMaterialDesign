package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Arno on 2017/10/23.
 *
 * 和 FloatingActionButton 联动，实现上滑消失，下滑出现的效果
 *
 */
public class TestScrollBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
    private static final String TAG = "TestScrollBehavior";

    public TestScrollBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 监听滚动，返回是否调用 onNestedScroll 等监听代码
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param nestedScrollAxes
     * @return
     */
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild,
                                       View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    /**
     * 正在滚动
     *
     * 这里我们只关心y轴方向的滑动，所以简单测试了dyConsumed、dyUnconsumed
     * dyConsumed > 0 && dyUnconsumed == 0 上滑中
     * dyConsumed == 0 && dyUnconsumed > 0 到边界了还在上滑
     *
     * dyConsumed < 0 && dyUnconsumed == 0 下滑中
     * dyConsumed == 0 && dyUnconsumed < 0 到边界了还在下滑
     *
     * @param coordinatorLayout     parent
     * @param child                 child
     * @param target                dependency
     * @param dxConsumed            x轴滑动的距离
     * @param dyConsumed            y轴滑动的距离
     * @param dxUnconsumed          到顶之后滑动的距离
     * @param dyUnconsumed          到顶之后滑动的距离
     */
    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        Log.i(TAG, String.format("onNestedScroll: dxConsumed==%d,dyConsumed==%d,dxUnConsumed==%d,dyUnConsumed==%d", dxConsumed,dyConsumed,dxUnconsumed,dyUnconsumed));
        /*
            不知为什么，使用了 hide show 方法后，只有第一次滑动能监听到，之后不再调用这个方法。
            像是 behavior 已经停止操作
         */
//        if (((dyConsumed > 0 && dyUnconsumed == 0)
//                || (dyConsumed == 0 && dyUnconsumed > 0))
//                && child.isShown()) {// 上滑隐藏
//            child.hide();
//        } else if (((dyConsumed < 0 && dyUnconsumed == 0)
//                || (dyConsumed == 0 && dyUnconsumed < 0))
//                && !child.isShown() ) {//下滑显示
//            child.show();
//        }

        if (((dyConsumed > 0 && dyUnconsumed == 0)
                || (dyConsumed == 0 && dyUnconsumed > 0))
                && child.getVisibility() != View.INVISIBLE) {// 上滑隐藏
            child.setVisibility(View.INVISIBLE);
        } else if (((dyConsumed < 0 && dyUnconsumed == 0)
                || (dyConsumed == 0 && dyUnconsumed < 0))
                && child.getVisibility() != View.VISIBLE ) {//下滑显示
            child.setVisibility(View.VISIBLE);
        }

    }

//    @Override
//    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, float velocityX, float velocityY, boolean consumed) {
//
//        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
//    }
}
