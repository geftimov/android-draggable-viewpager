package com.eftimoff.draggableviewpager;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class DraggableViewPager extends ViewPager {

    private boolean swipeable = true;
    private ViewPagerAdapter viewPagerAdapter;

    public DraggableViewPager(Context context) {
        super(context);
    }

    public DraggableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setFragmentManager(final FragmentManager fragmentManager) {
        //TODO Move this to attributes
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager, 3, 1, new DraggableViewPagerChangeListener());
        setAdapter(viewPagerAdapter);
        //Make all fragments live or the views are not created.
        setOffscreenPageLimit(viewPagerAdapter.getCount());
    }

    public void setAdapterPerPage(final int page, final SwapPositionsAdapter adapter) {
        viewPagerAdapter.setAdapterPerPage(page, adapter);
    }


    // Call this method in your motion events when you want to disable or enable
    // It should work as desired.
    public void setSwipeable(boolean swipeable) {
        this.swipeable = swipeable;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return (this.swipeable) && super.onInterceptTouchEvent(arg0);
    }

    private class DraggableViewPagerChangeListener implements PageChangerListener {

        @Override
        public void swipeToPage(int page) {
            if (page < 0 || page > viewPagerAdapter.getCount()) return;
            setCurrentItem(page, true);
        }

        @Override
        public void startSwiping() {
            Log.i("!!!!!!!!!!!!", "START SWIPING");
            setSwipeable(false);
        }

        @Override
        public void stopSwiping() {
            Log.i("!!!!!!!!!!!!", "STOP SWIPING");
            setSwipeable(true);
        }
    }
}
