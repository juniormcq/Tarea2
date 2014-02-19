package com.example.tarea1;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListFragment extends Fragment implements OnItemClickListener {
	ListView list;
	String tienda = "";
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		String[] arrayCountries = new String[]{"Tienda de Lego", "Tienda de Libros", "Tienda de zapatos", "Tienda de ropa",
				"Tienda de vinos","Tienda ultima"};
		ArrayList<String> countries = new ArrayList<String>(Arrays.asList(arrayCountries));
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,countries);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);

		
	
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_list, container,false);
		list = (ListView)view.findViewById(R.id.listView1);
		return view;
	}


	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// Inflate the menu; this adds items to the action bar if it is present.
		inflater.inflate(R.menu.main, menu);
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_share:
			if (!tienda.equals("")) {
				String msg = getString(R.string.msg_share, tienda); 
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
	@Override
	 public void onPrepareOptionsMenu(Menu menu){
		boolean landscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
		MenuItem share = menu.getItem(menu.size()-1);
		share.setVisible(landscape);	
	}
	
	@Override
	public void onItemClick(AdapterView<?>  adapterView, View view, int position, long arg3) {
		tienda = adapterView.getItemAtPosition(position).toString();
		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			FragmentManager manager = getActivity().getSupportFragmentManager();
			InfoActivity fragment = (InfoActivity) manager.findFragmentById(R.id.fragmentTiendaInfo);
			fragment.load(tienda);
		}else{
			Intent intent = new Intent(getActivity(), DetailActivity.class);
			intent.putExtra(DetailActivity.TIENDA, tienda);
			startActivity(intent);
		}
		
	}
	
	
}
