package com.eftimoff.draggableviewpager;

import android.view.LayoutInflater;
import android.view.View;

public interface PageAdapter {

    public View getView(final LayoutInflater layoutInflater, final int page, final int position);

    public Object getItem(final int page, final int position);

    public int itemCountInPage(int page);

    public int pageCount();
}
