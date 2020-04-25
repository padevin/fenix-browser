package com.blogspot.yatechno.fenixbrowser;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	
	
	private ArrayList<String> About = new ArrayList<>();
	
	private LinearLayout tamsayfa;
	private LinearLayout baslik;
	private LinearLayout ortabolum;
	private LinearLayout altbolum;
	private LinearLayout ust;
	private TextView logo;
	private EditText arama_metni;
	private ImageView ara;
	private ImageView facebook;
	private ImageView instagram;
	private ImageView youtube;
	private ImageView twitter;
	
	private Intent i = new Intent();
	private SharedPreferences arama;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		tamsayfa = (LinearLayout) findViewById(R.id.tamsayfa);
		baslik = (LinearLayout) findViewById(R.id.baslik);
		ortabolum = (LinearLayout) findViewById(R.id.ortabolum);
		altbolum = (LinearLayout) findViewById(R.id.altbolum);
		ust = (LinearLayout) findViewById(R.id.ust);
		logo = (TextView) findViewById(R.id.logo);
		arama_metni = (EditText) findViewById(R.id.arama_metni);
		ara = (ImageView) findViewById(R.id.ara);
		facebook = (ImageView) findViewById(R.id.facebook);
		instagram = (ImageView) findViewById(R.id.instagram);
		youtube = (ImageView) findViewById(R.id.youtube);
		twitter = (ImageView) findViewById(R.id.twitter);
		arama = getSharedPreferences("arama", Activity.MODE_PRIVATE);
		
		ara.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (arama_metni.getText().toString().contains(".com") && (!arama_metni.getText().toString().contains("http://") || !arama_metni.getText().toString().contains("https://"))) {
					arama.edit().putString("ara", "http://".concat(arama_metni.getText().toString())).commit();
					i.setClass(getApplicationContext(), TarayiciActivity.class);
					startActivity(i);
				}
				else {
					if (arama_metni.getText().toString().contains(".com") && (arama_metni.getText().toString().contains("http://") || arama_metni.getText().toString().contains("https://"))) {
						arama.edit().putString("ara", arama_metni.getText().toString()).commit();
						i.setClass(getApplicationContext(), TarayiciActivity.class);
						startActivity(i);
					}
					else {
						arama.edit().putString("ara", "https://www.google.com.tr/search?q=".concat(arama_metni.getText().toString())).commit();
						i.setClass(getApplicationContext(), TarayiciActivity.class);
						startActivity(i);
					}
				}
			}
		});
		
		facebook.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				i.setClass(getApplicationContext(), TarayiciActivity.class);
				startActivity(i);
			}
		});
		
		instagram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				i.setClass(getApplicationContext(), TarayiciActivity.class);
				startActivity(i);
			}
		});
		
		youtube.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				i.setClass(getApplicationContext(), TarayiciActivity.class);
				startActivity(i);
			}
		});
		
		twitter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
				i.setClass(getApplicationContext(), TarayiciActivity.class);
				startActivity(i);
			}
		});
	}
	private void initializeLogic() {
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		
	}
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
