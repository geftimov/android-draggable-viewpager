package com.eftimoff.draggableviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.HashMap;
import java.util.Map;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final int pages;
    private final int columns;
    private final PageChangerListener pageChangerListener;

    private Map<Integer, Fragment> fragmentMap = new HashMap<Integer, Fragment>();

    public ViewPagerAdapter(final FragmentManager fm, final int pages, final int columns, final PageChangerListener pageChangerListener) {
        super(fm);
        this.pages = pages;
        this.columns = columns;
        this.pageChangerListener = pageChangerListener;
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment fragment = fragmentMap.get(position);
        return fragment == null ? EmptyFragment.getInstance() : fragment;
    }

    @Override
    public int getCount() {
        return pages;
    }

    public void setAdapterPerPage(final int page, final SwapPositionsAdapter adapter) {
        final ViewPagerFragment fragment = ViewPagerFragment.getInstance(columns, page);
        fragment.setPageChangerListener(pageChangerListener);
        fragment.setAdapter(adapter);
        fragmentMap.put(page, fragment);
    }


}
