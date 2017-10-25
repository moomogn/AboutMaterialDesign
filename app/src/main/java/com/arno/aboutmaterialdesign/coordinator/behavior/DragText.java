package com.arno.aboutmaterialdesign.coordinator.behavior;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Arno on 2017/10/23.
 */

public class DragText extends AppCompatTextView {
    int ox = 0;
    int oy = 0;

    public DragText(Context context) {
        super(context);
    }

    public DragText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int nx = (int) event.getRawX();
        int ny = (int) event.getRawY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:

                CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) getLayoutParams();
                lp.leftMargin = lp.leftMargin + nx - ox;
                lp.topMargin = lp.topMargin + ny - oy;
                setLayoutParams(lp);
                requestLayout();

                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        ox = nx;
        oy = ny;

        return true;
    }
}
