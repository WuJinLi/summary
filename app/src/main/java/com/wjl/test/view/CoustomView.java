package com.wjl.test.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Scroller;

/**
 * author: WuJinLi
 * time  : 2018/12/20
 * desc  :
 */
public class CoustomView extends View {
    private int lastX;
    private int lastY;
    private Scroller scroller;

    public CoustomView(Context context) {
        super(context);
        scroller = new Scroller(context);
    }

    public CoustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    public CoustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);
    }

    public CoustomView(Context context, AttributeSet attrs, int defStyleAttr,
                       int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        scroller = new Scroller(context);
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offX = x - lastY;
//                int offY = y - lastY;
//
//                //1 使用layout方法实现
////                layout(getLeft() + offX, getTop() + offY, getRight() + offX, getBottom() + offY);
//
//                //2使用offsetLeftAndRight/offsetTopAndBottom来实现
////                offsetLeftAndRight(offX);
////                offsetTopAndBottom(offY);
//
//                //3使用LayoutParams实现
////                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) getLayoutParams();
////                params.leftMargin = getLeft() + offX;
////                params.topMargin = getTop() + offY;
////                setLayoutParams(params);
//
//
//                //scrollBy
//                ((View) getParent()).scrollBy(-offX, -offY);
//                break;
//        }
//        return true;
//    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();
        }
    }
}
