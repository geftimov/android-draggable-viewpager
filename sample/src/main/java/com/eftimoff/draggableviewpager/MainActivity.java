package com.eftimoff.draggableviewpager;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final DraggableViewPager draggableViewPager = (DraggableViewPager) findViewById(R.id.viewPager);
		draggableViewPager.setFragmentManager(getSupportFragmentManager());
		final MyAdapter myAdapter1 = new MyAdapter(new String[]{"guz", "stava", "ei", "kakvo"});
		draggableViewPager.setAdapterPerPage(0, myAdapter1);
		final MyAdapter myAdapter2 = new MyAdapter(new String[]{"aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa"});
		draggableViewPager.setAdapterPerPage(1, myAdapter2);
		final MyAdapter myAdapter3 = new MyAdapter(new String[]{"aaaaaaa", "aaaaaaa", "aaaaaaa", "aaaaaaa"});
		draggableViewPager.setAdapterPerPage(2, myAdapter3);
	}
}
