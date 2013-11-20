package com.sii.mysii.geolocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * @author qklein
 * LocationTracker
 * Tracks your position and call onLocationChanged() when it gets it
 *
 */
/**
 * @author isen
 *
 */  
public abstract class LocationTracker {

	private LocationManager locationManagerService;
	private LocationListener locationListener;
	private boolean isListening = false;

	private static final int TIME_BETWEEN_UPDATE_MILLIS = 30 * 60 * 1000;
	private static final int MINIMUM_METERS_TO_NEW_LOCATION = 300;

	private static Location location;

	public LocationTracker(Context context){
		// Get the location manager
		this.locationManagerService = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		// Define the listener
		this.locationListener = new LocationListener() {

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {

			}

			@Override
			public void onProviderEnabled(String provider) {

			}

			@Override
			public void onProviderDisabled(String provider) {

			}

			@Override
			public void onLocationChanged(Location location) {
				LocationTracker.location = new Location(location);
				LocationTracker.this.onLocationChanged();
			}
		};
		// Define the criteria how to select the locatioin provider -> use
		// default
		if(location == null) {
			LocationTracker.location = locationManagerService.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		}
		if(location == null) {
			LocationTracker.location = locationManagerService.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		}
		if(location == null) {
			LocationTracker.location = locationManagerService.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
		}
		// Start Listen for updates
		startListen();
	}

	/**
	 * Called when position change, must be implemented
	 */
	protected abstract void onLocationChanged();	

	/**
	 * Enable the update listeners
	 */
	public final void startListen(){
		if(!this.isListening) {
			if(locationManagerService.isProviderEnabled(LocationManager.GPS_PROVIDER)){
				locationManagerService.requestLocationUpdates(LocationManager.GPS_PROVIDER, TIME_BETWEEN_UPDATE_MILLIS, MINIMUM_METERS_TO_NEW_LOCATION, this.locationListener);
			}
			if(locationManagerService.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
				locationManagerService.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, TIME_BETWEEN_UPDATE_MILLIS, MINIMUM_METERS_TO_NEW_LOCATION, this.locationListener);
			}
			if(locationManagerService.isProviderEnabled(LocationManager.PASSIVE_PROVIDER)){
				locationManagerService.requestLocationUpdates(LocationManager.PASSIVE_PROVIDER, TIME_BETWEEN_UPDATE_MILLIS, MINIMUM_METERS_TO_NEW_LOCATION, this.locationListener);
			}
			this.isListening = true;
		}
	}

	/**
	 * Disable the update listeners
	 */
	public final void stopListen(){
		if(this.isListening){
			locationManagerService.removeUpdates(this.locationListener);
			this.isListening = false;
		}
	}

	/**
	 * Gets the location
	 * @return the current location
	 */
	public static Location getLocation(){
		return location!=null ? new Location(location) : null;
	}

}