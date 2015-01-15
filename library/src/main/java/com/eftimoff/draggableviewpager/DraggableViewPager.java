package com.eftimoff.draggableviewpager;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class DraggableViewPager extends ViewPager {

    private ViewPagerAdapter viewPagerAdapter;

    public DraggableViewPager(Context context) {
        super(context);
        init();
    }

    public DraggableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setFragmentManager(final FragmentManager fragmentManager) {
        viewPagerAdapter = new ViewPagerAdapter(fragmentManager);
        setAdapter(viewPagerAdapter);
    }

    private void init() {

    }
}
