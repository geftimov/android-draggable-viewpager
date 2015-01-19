package com.eftimoff.draggableviewpager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends SwapPositionsAdapter<MyAdapter.ViewHolder> {
	private String[] mDataset;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		public TextView mTextView;

		public ViewHolder(View v) {
			super(v);
			mTextView = (TextView) v.findViewById(R.id.info_text);
		}
	}

	@Override
	public void swapPositions(final int from, final int to) {
		final String temp = mDataset[from];
		mDataset[from] = mDataset[to];
		mDataset[to] = temp;
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public MyAdapter(String[] myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
	                                               int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.my_text_view, parent, false);
		// set the view's size, margins, paddings and layout parameters
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		holder.mTextView.setText(mDataset[position]);

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mDataset.length;
	}
}