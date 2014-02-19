package com.example.tarea1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.util.Linkify;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends Activity {
	private String country2 = "";
	public static final String TIENDA2 = "country";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		Intent intent = getIntent();
		country2 = intent.getStringExtra(TIENDA2);
		ImageView txtm = (ImageView)findViewById(R.id.imageView1);
		TextView txtm1 = (TextView)findViewById(R.id.textView1);

		if (country2.equals("Tienda de Lego")){
			
			txtm.setImageResource(R.drawable.lego);
			txtm1.setText("Exelente tienda de Legos, ven con los nenes");
		}else if (country2.equals("Tienda de Libros")){
			
			txtm.setImageResource(R.drawable.book);
			txtm1.setText("Par los amantes de la lectura");

		}else if (country2.equals("Tienda de zapatos")){
			txtm.setImageResource(R.drawable.shoe);
			txtm1.setText("Zapatos para toda la familia");

			
		}else if (country2.equals("Tienda de ropa")){
			
			txtm.setImageResource(R.drawable.ropa);
			txtm1.setText("La mejor ropa, la mejor marca");

		}else if (country2.equals("Tienda de vinos")){
			
			txtm.setImageResource(R.drawable.vino);
			txtm1.setText("Exelencian vinos");

		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.image, menu);
		return true;
	}

}
