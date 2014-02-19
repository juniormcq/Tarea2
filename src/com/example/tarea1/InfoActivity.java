package com.example.tarea1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends Fragment implements OnClickListener{
	private String country = "";
	String numero;
	private Button btnAdd;
	private Button btnAdd2;
	private TextView txtm;
	private TextView txtm1;
	private TextView txtm2;
	private TextView txtm3;
	private TextView txtm4;
	private TextView txtm5;
	private TextView txtm6;
	private TextView txtm7;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (getActivity() instanceof DetailActivity) {
		country = ((DetailActivity)getActivity()).getTienda();
		load(country);
		}
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.activity_detail,container);
		txtm = (TextView)view.findViewById(R.id.txtname);
		txtm1 = (TextView)view.findViewById(R.id.textView1);
		txtm2= (TextView)view.findViewById(R.id.textView2);
		txtm3 = (TextView)view.findViewById(R.id.textView3);
		txtm4 = (TextView)view.findViewById(R.id.textView4);
		txtm5 = (TextView)view.findViewById(R.id.textView5);
		txtm6 = (TextView)view.findViewById(R.id.textView6);
		txtm7 = (TextView)view.findViewById(R.id.textView7);
		btnAdd = (Button)view.findViewById(R.id.button1);
		btnAdd2 = (Button)view.findViewById(R.id.button2);
		return view;
	}

	@Override
	public void onClick(View v) {
		String tienda = country;
		if (v.getId() == btnAdd.getId()){

			Intent intentx = new Intent();
			intentx.putExtra(ImageActivity.TIENDA2, tienda);
			startActivity(intentx);
		}else if (v.getId()== btnAdd2.getId()) {
			Log.e("entro", "entro" );
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:" + numero));
			startActivity(callIntent);
			
		}	
		
	}
	
	public void load(String country){
		btnAdd.setOnClickListener(this);
		btnAdd2.setOnClickListener(this);
		txtm.setText(country);
		txtm7.setText("Horarios");
		if (country .equals("Tienda de Lego")){
			
			txtm1.setText("34 Main St, Queens, NY 11367, EE.UU.");
			Linkify.addLinks(txtm1, Linkify.MAP_ADDRESSES);
			txtm2.setText("23548792");
			numero = "23548792";
			Linkify.addLinks(txtm2, Linkify.ALL);
			txtm3.setText("www.tienndadelego.com");
			Linkify.addLinks(txtm3, Linkify.ALL);
			txtm4.setText("tiendadelego@gmail.com");
			Linkify.addLinks(txtm4, Linkify.ALL);
			txtm6.setText("Lunes-Viernes: 9 a.m. a 7 p.m.");
			txtm5.setText("Sabados: 10 a.m. a 4 p.m.");
		}else if (country .equals("Tienda de Libros")){
			
			txtm1.setText("34 Main St, Queens, NY 11367, EE.UU.");
			Linkify.addLinks(txtm1, Linkify.MAP_ADDRESSES);
			txtm2.setText("23358391");
			numero = "23358391";
			Linkify.addLinks(txtm2, Linkify.ALL);
			txtm3.setText("www.tienndadelibros.com");
			Linkify.addLinks(txtm3, Linkify.ALL);
			txtm4.setText("tiendadelibros@gmail.com");
			Linkify.addLinks(txtm4, Linkify.ALL);
			txtm6.setText("Lunes-Viernes: 7 a.m. a 6 p.m.");
			txtm5.setText("Sabados: 10 a.m. a 1 p.m.");
		}else if (country .equals("Tienda de zapatos")){
			
			txtm1.setText("34 Main St, Queens, NY 11367, EE.UU.");
			Linkify.addLinks(txtm1, Linkify.MAP_ADDRESSES);
			txtm2.setText("22134566");
			numero = "22134566";
			Linkify.addLinks(txtm2, Linkify.ALL);
			txtm3.setText("www.tienndadezapatos.com");
			Linkify.addLinks(txtm3, Linkify.ALL);
			txtm4.setText("tiendadezapatos@gmail.com");
			Linkify.addLinks(txtm4, Linkify.ALL);
			txtm6.setText("Lunes-Viernes: 8 a.m. a 6 p.m.");
			txtm5.setText("Sabados: 10 a.m. a 4 p.m.");
		}else if (country .equals("Tienda de ropa")){
			
			txtm1.setText("34 Main St, Queens, NY 11367, EE.UU.");
			Linkify.addLinks(txtm1, Linkify.MAP_ADDRESSES);
			txtm2.setText("22334567");
			numero = "22334567";
			Linkify.addLinks(txtm2, Linkify.ALL);
			txtm3.setText("www.tienndaderopa.com");
			Linkify.addLinks(txtm3, Linkify.ALL);
			txtm4.setText("tiendaderopa@gmail.com");
			Linkify.addLinks(txtm4, Linkify.ALL);
			txtm6.setText("Lunes-Viernes: 10 a.m. a 9 p.m.");
			txtm5.setText("Sabados: 9 a.m. a 6 p.m.");
		}else if (country .equals("Tienda de vinos")){
			
			txtm1.setText("34 Main St, Queens, NY 11367, EE.UU.");
			Linkify.addLinks(txtm1, Linkify.MAP_ADDRESSES);
			txtm2.setText("2658871");
			numero = "2658871";
			Linkify.addLinks(txtm2, Linkify.ALL);
			txtm3.setText("www.tienndadevinos.com");
			Linkify.addLinks(txtm3, Linkify.ALL);
			txtm4.setText("tiendadevinos@gmail.com");
			Linkify.addLinks(txtm4, Linkify.ALL);
			txtm6.setText("Lunes-Viernes: 10 a.m. a 6 p.m.");
			txtm5.setText("Sabados: 10 a.m. a 12 p.m.");
		}
	}

}
