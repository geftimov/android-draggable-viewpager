package com.eftimoff.draggableviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eftimoff.mylibrary.R;

import java.util.Random;

public class ViewPagerFragment extends Fragment {

	public static final String COLUMNS_NUMBER = "columns_number";
	private RecyclerView viewPagerRecyclerView;
	private SwapPositionsAdapter adapter;

	public static ViewPagerFragment getInstance(final int columns) {
		final ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
		final Bundle bundle = new Bundle();
		bundle.putInt(COLUMNS_NUMBER, columns);
		viewPagerFragment.setArguments(bundle);
		return viewPagerFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
		viewPagerRecyclerView = (RecyclerView) view.findViewById(R.id.viewPagerRecyclerView);
		//TODO Delete this after completing everything
		final int color = getRandomColor();
		view.setBackgroundColor(color);
		return view;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		final int numberOfColumns = getNumberOfColumns();

		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		viewPagerRecyclerView.setHasFixedSize(true);

		// use a linear layout manager
		final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), numberOfColumns);
		viewPagerRecyclerView.setLayoutManager(gridLayoutManager);

		viewPagerRecyclerView.setAdapter(adapter);

		final DragDropTouchListener dragDropTouchListener = new DragDropTouchListener(viewPagerRecyclerView, getActivity()) {
			@Override
			protected void onItemSwitch(RecyclerView recyclerView, int from, int to) {
				adapter.swapPositions(from, to);
				adapter.notifyItemChanged(to);
				adapter.notifyItemChanged(from);
			}

			@Override
			protected void onItemDrop(RecyclerView recyclerView, int position) {
			}

			@Override
			protected void swipePageLeft() {

			}

			@Override
			protected void swipePageRight() {

			}
		};
		viewPagerRecyclerView.addOnItemTouchListener(dragDropTouchListener);
	}

	public void setAdapter(final SwapPositionsAdapter adapter) {
		this.adapter = adapter;

		if (viewPagerRecyclerView != null) {
			viewPagerRecyclerView.setAdapter(adapter);
		}
	}

	private int getNumberOfColumns() {
		final int defaultColumnNumber = 4;
		final Bundle arguments = getArguments();
		if (arguments == null) return defaultColumnNumber;
		return arguments.getInt(COLUMNS_NUMBER, defaultColumnNumber);
	}

	private int getRandomColor() {
		final Random random = new Random();
		return Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
