package com.sample.swipelistview.view;

import android.view.View;

/**
 * Created by honjane on 2015/12/25.
 */
public interface OnSlideListener {
    public static final int SLIDE_STATUS_OFF = 0;
    public static final int SLIDE_STATUS_START_SCROLL = 1;
    public static final int SLIDE_STATUS_ON = 2;

    /**
     * @param view   current SlideView
     * @param status SLIDE_STATUS_ON or SLIDE_STATUS_OFF
     */
    public void onSlide(View view, int status);
}
