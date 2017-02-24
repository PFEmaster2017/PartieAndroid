package com.localisation;

import com.google.android.maps.MapActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class EnregistrerVoiture extends MapActivity implements
	LocationListener {

    private MapView mapView = null;
    private LocationManager lm = null;
    private double lat = 0;
    private double lng = 0;
    private MapController mc = null;
    private MyLocationOverlay myLocation = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_enregistrer_voiture);
	mapView = (MapView) this.findViewById(R.id.mapView);
	mapView.setBuiltInZoomControls(true);

	lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);
	lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, this);
	lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 0,
		this);

	mc = mapView.getController();
	mc.setZoom(15);

	myLocation = new MyLocationOverlay(getApplicationContext(), mapView);
	myLocation.runOnFirstFix(new Runnable() {
	    public void run() {
		mc.animateTo(myLocation.getMyLocation());
		mc.setZoom(17);
	    }
	});
	mapView.getOverlays().add(myLocation);
    }

    @Override
    protected void onResume() {
	super.onResume();
	myLocation.enableMyLocation();
	myLocation.enableCompass();
    }

    @Override
    protected boolean isRouteDisplayed() {
	return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
	if (keyCode == KeyEvent.KEYCODE_S) {
	    mapView.setSatellite(!mapView.isSatellite());
	    return true;
	}
	return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onLocationChanged(Location location) {
	lat = location.getLatitude();
	lng = location.getLongitude();
	Toast.makeText(
		getBaseContext(),
		"Location change to : Latitude = " + lat + " Longitude = "
			+ lng, Toast.LENGTH_SHORT).show();
	GeoPoint p = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
	mc.animateTo(p);
	mc.setCenter(p);
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}
