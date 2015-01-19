package com.eftimoff.draggableviewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eftimoff.mylibrary.R;

import java.util.Random;

public class EmptyFragment extends Fragment {


	public static Fragment getInstance() {
		final EmptyFragment emptyFragment = new EmptyFragment();
		return emptyFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.fragment_empty, container, false);
		//TODO Delete this after completing everything
		final int color = getRandomColor();
		view.setBackgroundColor(color);
		return view;
	}

	private int getRandomColor() {
		final Random random = new Random();
		return Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}
}
