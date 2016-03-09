package com.example.gmap;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends FragmentActivity{
private static final int GPS_ERRORDIALOG_REQUEST = 9001;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(ServicesOK()){
			Toast.makeText(MainActivity.this, "Ready to use MAP!!!", Toast.LENGTH_LONG).show();
			setContentView(R.layout.activity_map);
			//setContentView(R.layout.activity_main);
			
			
		}
		else
		{
		setContentView(R.layout.activity_main);
		}
	
//		Intent i = new Intent(getApplicationContext(),MapdemoActivity.class);
//		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
//	public void displayMap(View view){
//		
//		Intent i = new Intent(MainActivity.this,MapdemoActivity.class);
//		startActivity(i);
//	}
	
	public boolean ServicesOK() {
		int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
		if(isAvailable == ConnectionResult.SUCCESS){
			return true;
			
		}
		else if(GooglePlayServicesUtil.isUserRecoverableError(isAvailable)){
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, this, GPS_ERRORDIALOG_REQUEST);
			dialog.show();
		}
		else{
			Toast.makeText(MainActivity.this, "Can't connect to google play services!!!", Toast.LENGTH_LONG).show();
		}
			return false;
	}
}
