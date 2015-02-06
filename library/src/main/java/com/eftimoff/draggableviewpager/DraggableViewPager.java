package com.eftimoff.draggableviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;

import com.eftimoff.draggableviewpager.callbacks.OnPageChangedListener;

public class DraggableViewPager extends HorizontalScrollView implements ViewPagerContainer, OnGestureListener {

    private static final int FLING_VELOCITY = 500;
    private int activePage = 0;
    private boolean activePageRestored = false;

    private DragDropGrid grid;
    private DraggableViewPagerAdapter adapter;
    private OnClickListener listener;
    private GestureDetector gestureScanner;

    private OnPageChangedListener pageChangedListener;
    private int xmlRes;

    public DraggableViewPager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setBackground(attrs);

        initPagedScroll();
        initGrid();
    }

    public DraggableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

        setBackground(attrs);

        initPagedScroll();
        initGrid();
    }

    public DraggableViewPager(Context context) {
        super(context);


        initPagedScroll();
        initGrid();
    }

    public DraggableViewPager(Context context, AttributeSet attrs, int defStyle, DraggableViewPagerAdapter adapter) {
        super(context, attrs, defStyle);

        setBackground(attrs);

        this.adapter = adapter;
        initPagedScroll();
        initGrid();
    }

    public DraggableViewPager(Context context, AttributeSet attrs, DraggableViewPagerAdapter adapter) {
        super(context, attrs);

        setBackground(attrs);

        this.adapter = adapter;
        initPagedScroll();
        initGrid();
    }

    public DraggableViewPager(Context context, DraggableViewPagerAdapter adapter) {
        super(context);
        this.adapter = adapter;
        initPagedScroll();
        initGrid();
    }

    private void initGrid() {
        final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final ScrollView scrollView = new ScrollView(getContext()) {
            // true if we can scroll (not locked)
            // false if we cannot scroll (locked)
            private boolean mScrollable = false;

            public void setScrollingEnabled(boolean enabled) {
                mScrollable = enabled;
            }

            public boolean isScrollable() {
                return mScrollable;
            }

            @Override
            public boolean onTouchEvent(MotionEvent ev) {
                switch (ev.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // if we can scroll pass the event to the superclass
                        if (mScrollable) return super.onTouchEvent(ev);
                        // only continue to handle the touch event if scrolling enabled
                        return mScrollable; // mScrollable is always false at this point
                    default:
                        return super.onTouchEvent(ev);
                }
            }

            @Override
            public boolean onInterceptTouchEvent(MotionEvent ev) {
                // Don't do anything with intercepted touch events if
                // we are not scrollable
                if (!mScrollable) return false;
                else return super.onInterceptTouchEvent(ev);
            }

        };
        grid = new DragDropGrid(getContext());
        if (xmlRes != -1) {
            grid.setBackgroundResource(xmlRes);
        }
        scrollView.addView(grid);
        addView(scrollView, layoutParams);
//        addView(grid);
    }

    private void setBackground(AttributeSet attrs) {
        final String xmlns = "http://schemas.android.com/apk/res/android";
        xmlRes = attrs.getAttributeResourceValue(xmlns, "background", -1);
    }

    public void initPagedScroll() {


        setScrollBarStyle(SCROLLBARS_INSIDE_OVERLAY);

        if (!isInEditMode()) {
            gestureScanner = new GestureDetector(getContext(), this);
        }

        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                boolean specialEventUsed = gestureScanner.onTouchEvent(event);
                if (!specialEventUsed && (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)) {
                    int scrollX = getScrollX();
                    int onePageWidth = v.getMeasuredWidth();
                    int page = ((scrollX + (onePageWidth / 2)) / onePageWidth);
                    scrollToPage(page);
                    return true;
                } else {
                    return specialEventUsed;
                }
            }
        });
    }

    public void setOnPageChangedListener(OnPageChangedListener listener) {
        this.pageChangedListener = listener;
    }

    public void setAdapter(DraggableViewPagerAdapter adapter) {
        this.adapter = adapter;
        grid.setAdapter(adapter);
        grid.setContainer(this);
    }

    public void setClickListener(OnClickListener l) {
        this.listener = l;
        grid.setOnClickListener(l);
    }

    public boolean onLongClick(View v) {
        return grid.onLongClick(v);
    }

    public void removeItem(int page, int index) {
        grid.removeItem(page, index);
    }

    public void notifyDataSetChanged() {
        grid.reloadViews();
    }

    @Override
    public void scrollToPage(int page) {
        activePage = page;
        int onePageWidth = getMeasuredWidth();
        int scrollTo = page * onePageWidth;
        smoothScrollTo(scrollTo, 0);
        if (pageChangedListener != null)
            pageChangedListener.onPageChanged(this, page);
    }

    @Override
    public void scrollLeft() {
        int newPage = activePage - 1;
        if (canScrollToPreviousPage()) {
            scrollToPage(newPage);
        }
    }

    @Override
    public void scrollRight() {
        int newPage = activePage + 1;
        if (canScrollToNextPage()) {
            scrollToPage(newPage);
        }
    }

    @Override
    public int currentPage() {
        return activePage;
    }

    @Override
    public void enableScroll() {
        requestDisallowInterceptTouchEvent(false);
    }

    @Override
    public void disableScroll() {
        requestDisallowInterceptTouchEvent(true);
    }

    @Override
    public boolean canScrollToNextPage() {
        int newPage = activePage + 1;
        return (newPage < adapter.pageCount());
    }

    @Override
    public boolean canScrollToPreviousPage() {
        int newPage = activePage - 1;
        return (newPage >= 0);
    }

    public void restoreCurrentPage(int currentPage) {
        activePage = currentPage;
        activePageRestored = true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        if (activePageRestored) {
            activePageRestored = false;
            scrollToRestoredPage();
        }
    }

    private void scrollToRestoredPage() {
        scrollToPage(activePage);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent evt1, MotionEvent evt2, float velocityX, float velocityY) {
        if (velocityX < -FLING_VELOCITY) {
            scrollRight();
            return true;
        } else if (velocityX > FLING_VELOCITY) {
            scrollLeft();
            return true;
        }
        return false;
    }

    @Override
    public void onLongPress(MotionEvent arg0) {
    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        return false;
    }
}
