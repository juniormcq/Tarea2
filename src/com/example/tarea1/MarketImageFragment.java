package com.example.tarea1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MarketImageFragment extends Fragment {
	ViewPager viewPager;
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		FlagPagerAdapter adapter = new FlagPagerAdapter(getChildFragmentManager());
		viewPager.setAdapter(adapter);
		
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view =inflater.inflate(R.layout.fragment_market_imges, container, false);
		viewPager = (ViewPager)view.findViewById(R.id.pager);
		
		viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
		
		return   view;
				
	}
	

	
	

}
