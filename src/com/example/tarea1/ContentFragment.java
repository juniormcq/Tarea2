package com.example.tarea1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends Fragment implements TabListener
	{
		Fragment[] fragments = new Fragment[] { new ListFragment(),new MapsFragment()};
		
		
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			ActionBar actionbar = ((MainActivity)getActivity()).getSupportActionBar();

			
			
			actionbar.addTab(actionbar.newTab()
					.setText(getString(R.string.tittleT))
					.setTabListener(this));
			actionbar.addTab(actionbar.newTab()
					.setText(getString(R.string.TittleMaps))
					.setTabListener(this));
			
			FragmentManager manager = getActivity().getSupportFragmentManager();
			manager.beginTransaction().add(R.id.mainContent, fragments[0])
			.add(R.id.mainContent, fragments[1]).commit();
		
		}
		@Override
		public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
				Fragment toHide = null;
				Fragment toShow = null;
				switch(tab.getPosition()){
				case 0:
					toHide = fragments[1];
					toShow = fragments[0];
					break;
				case 1:
					toHide = fragments[0];
					toShow = fragments[1];
					break;
					
				}
				ft.hide(toHide).show(toShow);
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			return inflater.inflate(R.layout.fragmentcontent, container, false);
		}
		

			
		
		@Override
		public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
			// TODO Auto-generated method stub
			
		}

}
