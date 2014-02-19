package com.example.tarea1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	private ListView drawerList;
    private String[] drawerOptions;
    private DrawerLayout drawerLayout;
	Fragment[] fragments = new Fragment[] { new MarketImageFragment(), new ContentFragment(),new OtroActivity()};
	private ActionBarDrawerToggle drawertoggle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		drawerList = (ListView) findViewById(R.id.leftDraw);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
		drawerOptions = getResources().getStringArray(R.array.drawer_options);
		drawerList.setAdapter(new ArrayAdapter<String>(this,R.layout.drawer_list_item,drawerOptions));
		drawerList.setOnItemClickListener(new DrawerItemClickListener());
	drawertoggle = new ActionBarDrawerToggle(this,drawerLayout,R.drawable.ic_action_overflow,R.string.Dopen,R.string.Dclose){
			 public void onDrawerClosed(View view){
				 ActivityCompat.invalidateOptionsMenu(MainActivity.this);
			 }
			 public void onDrawerOpened(View view){
				 ActivityCompat.invalidateOptionsMenu(MainActivity.this);

			 }
		 };
		 
		 drawerLayout.setDrawerListener(drawertoggle);
		 

	        ActionBar actionBar = getSupportActionBar();
			actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);	
	        actionBar.setTitle(drawerOptions[0]);
	    	actionBar.show();
	        actionBar.setDisplayHomeAsUpEnabled(true);
	        actionBar.setHomeButtonEnabled(true);
		 
		 FragmentManager manager = getSupportFragmentManager();
	        manager.beginTransaction()
	         .add(R.id.contentFrame, fragments[0])
	         .add(R.id.contentFrame, fragments[1])
	         .add(R.id.contentFrame, fragments[2])
	         	         .hide(fragments[1])
	         	         .hide(fragments[2])
	         .commit();	
		
	        

	}
	public void setContent(int index) {
		Fragment toHide = null;
		Fragment toHide2 = null;
		Fragment toShow = null;
		ActionBar actionBar = getSupportActionBar();
		switch (index) {
			case 0:
				toHide = fragments[1];
				toHide2 = fragments[2];
				toShow = fragments[0];	
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);	

				break;
			case 1:
				toHide = fragments[0];
				toHide2 = fragments[2];
				toShow = fragments[1];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
				break;
			case 2:
				toHide = fragments[0];
				toHide2 = fragments[1];
				toShow = fragments[2];
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);	
				break;
		}	
        actionBar.setTitle(drawerOptions[index]);

		FragmentManager manager = getSupportFragmentManager();

		manager.beginTransaction()
		.hide(toHide)
		.show(toShow)
			.commit();	
        drawerList.setItemChecked(index, true);
        drawerLayout.closeDrawer(drawerList);	
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawertoggle.onConfigurationChanged(newConfig);
	}
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawertoggle.syncState();
	}
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId()==android.R.id.home){
			if(drawerLayout.isDrawerOpen(drawerList)){
				drawerLayout.closeDrawer(drawerList);
			}else{
				drawerLayout.openDrawer(drawerList);
			}
		return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class DrawerItemClickListener implements ListView.OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int position,
				long arg3) {
			setContent(position);			
		}
		
	}

}
