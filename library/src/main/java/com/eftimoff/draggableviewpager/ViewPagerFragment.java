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

public class ViewPagerFragment extends Fragment {

    public static Fragment getInstance() {
        final ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        return viewPagerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, null);
        final Random random = new Random();
        final int color = Color.argb(255, random.nextInt(255), random.nextInt(255), random.nextInt(255));
        view.setBackgroundColor(color);
        return view;
    }
}
