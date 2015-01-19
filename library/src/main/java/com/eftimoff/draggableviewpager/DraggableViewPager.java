package com.eftimoff.draggableviewpager;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DraggableViewPager extends ViewPager {

	private boolean swipeable = true;
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
		viewPagerAdapter = new ViewPagerAdapter(fragmentManager, 3, 1);
		setAdapter(viewPagerAdapter);
	}

	public void setAdapterPerPage(final int page, final SwapPositionsAdapter adapter) {
		viewPagerAdapter.setAdapterPerPage(page, adapter);


	}

	public void init() {
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				//Do something after 100ms
				final int currentItem = getCurrentItem();
				setCurrentItem(currentItem + 1, true);
			}
		}, 10000);
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
}
