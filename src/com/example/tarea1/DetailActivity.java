package com.example.tarea1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class DetailActivity extends FragmentActivity {
	private String country = "";
	public static final String TIENDA = "country";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_fragment);
		Intent intent = getIntent();
		country = intent.getStringExtra(TIENDA);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_share:
			if (!country.equals("")) {
				String msg = getString(R.string.msg_share, country); 
				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SEND);	
				intent.putExtra(Intent.EXTRA_TEXT,msg);
				intent.setType("text/plain");
				startActivity(Intent.createChooser(intent, getResources().getText(R.string.action_share)));
			}
			return true;
		case R.id.action_favorite:	
			return true;
		
		default :
			return super.onOptionsItemSelected(item);
		}	
	
	}
	public String getTienda() {
		return country;
	}

}
