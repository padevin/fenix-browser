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
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;

public class TarayiciActivity extends AppCompatActivity {
	
	
	private String sa = "";
	
	private LinearLayout linear1;
	private WebView webview;
	private ImageView anasayfa;
	private LinearLayout ustbar;
	private ImageView ara;
	private EditText url;
	private ImageView sil;
	
	private Intent i = new Intent();
	private SharedPreferences arama;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.tarayici);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		webview = (WebView) findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setSupportZoom(true);
		anasayfa = (ImageView) findViewById(R.id.anasayfa);
		ustbar = (LinearLayout) findViewById(R.id.ustbar);
		ara = (ImageView) findViewById(R.id.ara);
		url = (EditText) findViewById(R.id.url);
		sil = (ImageView) findViewById(R.id.sil);
		arama = getSharedPreferences("arama", Activity.MODE_PRIVATE);
		
		webview.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		anasayfa.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				webview.loadUrl("http://www.google.com.tr");
				_urlbilgisi();
			}
		});
		
		ustbar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				
			}
		});
		
		ara.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				webview.loadUrl("https://www.google.com.tr/search?q=".concat(url.getText().toString()));
				_urlbilgisi();
			}
		});
		
		sil.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				url.setText("");
			}
		});
	}
	private void initializeLogic() {
		webview.loadUrl(arama.getString("ara", ""));
		url.setText(webview.getUrl());
		sa = url.getText().toString();
		_urlbilgisi();
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
		if (webview.canGoBack()) {
			webview.goBack();
		}
		else {
			i.setClass(getApplicationContext(), MainActivity.class);
			startActivity(i);
		}
		_urlbilgisi();
	}
	private void _urlbilgisi () {
		url.setText(webview.getUrl());
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
