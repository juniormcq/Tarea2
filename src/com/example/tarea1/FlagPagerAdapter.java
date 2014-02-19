package com.example.tarea1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FlagPagerAdapter extends FragmentPagerAdapter {
	private int[] arrayFlags= new int[]{
			R.drawable.promocion1,
			R.drawable.promocion2,
			R.drawable.promocion3,
			R.drawable.promocion4,
			R.drawable.promocion5,
			};

	public FlagPagerAdapter(FragmentManager fm) {
		super(fm);

	}

	@Override
	public Fragment getItem(int position) {
	
		
		Fragment fragment =new FragmentImages();
		Bundle args=new Bundle();
		args.putInt(FragmentImages.RESOURCE, arrayFlags[position]);
		
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public int getCount() {

		return arrayFlags.length;
	}

}
