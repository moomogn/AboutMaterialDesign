package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Arno on 2017/10/23.
 */

public class TestDragBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String TAG = "TestDragBehavior";
    private int width;
    private int height;

    /**
     * 这个构造方法必须重载，因为在CoordinatorLayout里利用反射去获取Behavior的时候就是拿的这个构造
     */
    public TestDragBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        width  = context.getResources().getDisplayMetrics().widthPixels;
        height  = context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 是否调用 onDependentViewChanged
     * @param parent        父容器
     * @param child         子视图
     * @param dependency    依赖视图
     * @return              是否依赖
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof DragText;
    }

    /**
     * 在这里我们定义 child 要执行的具体动作
     * @return  child是否要执行相应动作
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        int top = dependency.getTop();
        int left = dependency.getLeft();

        int x = width - left - child.getWidth();
        int y = height - top - child.getHeight();

        setPosition(child, x, y);

        return true;
    }

    private void setPosition(View child, int x, int y) {
        CoordinatorLayout.MarginLayoutParams layoutParams = (CoordinatorLayout.MarginLayoutParams) child.getLayoutParams();
        layoutParams.leftMargin = x;
        layoutParams.topMargin = y;
        child.setLayoutParams(layoutParams);
    }

}
