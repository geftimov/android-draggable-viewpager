package com.eftimoff.draggableviewpager;

import android.support.v7.widget.RecyclerView;

public abstract class SwapPositionsAdapter<VH extends android.support.v7.widget.RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

	public abstract void swapPositions(final int from, final int to);
}
