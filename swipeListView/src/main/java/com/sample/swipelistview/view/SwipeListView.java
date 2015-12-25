package com.sample.swipelistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by honjane on 2015/12/25.
 */
public class SwipeListView extends ListView{
    private static final String TAG = "SwipeListView";

    public static SwipeView mSwipeView;
    private int mPosition;

    public SwipeListView(Context context) {
        super(context);
    }

    public SwipeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void shrinkItem(int position) {
        View item = getChildAt(position);

        if (item != null) {
            try {
                ((SwipeView) item).shrink();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                int x = (int) event.getX();
                int y = (int) event.getY();
                // 获得当前行位置
                int position = pointToPosition(x, y);
                Log.e(TAG, "postion=" + position);
                if (position != INVALID_POSITION) {
                    /*
                     由于pointToPosition返回的是ListView所有item中被点击的item的position，
                     而listview只会缓存可见的item，因此getChildAt()后需要通过减去getFirstVisiblePosition()
                     来计算被点击的item在可见items中的位置。
                     */
                    int firstPos = getFirstVisiblePosition();
                    mSwipeView = (SwipeView) getChildAt(position- firstPos);
                    Log.d(TAG, "position=" + position +",firstPos ="+firstPos);
                }
            }
            default:
                break;
        }

        if (mSwipeView != null) {
            mSwipeView.onSlideTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

}
