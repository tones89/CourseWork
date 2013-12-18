package com.denovan.anthony.coursework.ubi.mobile;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;



//Sourced from http://www.androidhive.info/2012/07/android-gps-location-manager-tutorial/
public class GetUserLoc extends Service implements LocationListener 
{

	private final Context context;
	 
    // flag for GPS status
    boolean isLocEnabled = false;
 
    // flag for network status
    boolean NetworkEnabled = false;
 
    boolean LocationAccesible = false;
 
    Location location; // location
    double latitude; // latitude
    double longitude; // longitude
 
    // The distance in metres between updates, sets the accuracy of the lookup
    private static final long MIN_DISTANCE = 10; // 10 meters
 
    // Time between updates
    private static final long MIN_TIME = 1000 * 60 * 1; //1 minute between updates, too small a tiem window will cause the app to slow or crash
 
    // The default constructor
    protected LocationManager locationManager;
 
    public GetUserLoc (Context context) {
        this.context= context;
        GetUserLocation();
    }
        
        
       public Location GetUserLocation()
       {
    	   
    	   try {
    		   //Get the location manager
               locationManager = (LocationManager) context
                       .getSystemService(LOCATION_SERVICE);
    
               // enabling gps
               isLocEnabled = locationManager
                       .isProviderEnabled(LocationManager.GPS_PROVIDER);
    
               // retrieving the current networking status
               NetworkEnabled = locationManager
                       .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    
               if (!isLocEnabled && !NetworkEnabled) {
                   // no network provider is enabled
               } else {
                   this.LocationAccesible = true;
                   // allows updates of the location based on the given provider and distancs
                   if (NetworkEnabled) {
                       locationManager.requestLocationUpdates(
                               LocationManager.NETWORK_PROVIDER,
                               MIN_TIME,
                               MIN_DISTANCE, this);
                       Log.d("Network", "Network");
                       //If available the location manager will get the current location's lat and long values since the last update
                       if (locationManager != null) {
                           location = locationManager
                                   .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                           if (location != null) {
                               latitude = location.getLatitude();
                               longitude = location.getLongitude();
                           }
                       }
                   }
                   // This allows a finer grained search approach to the lookup using gps sattelites rather than just the network sattelites.
                   if (isLocEnabled) {
                       if (location == null) {
                           locationManager.requestLocationUpdates(
                                   LocationManager.GPS_PROVIDER,
                                   MIN_TIME,
                                   MIN_DISTANCE, this);
                           Log.d("GPS Enabled", "GPS Enabled");
                           if (locationManager != null) {
                               location = locationManager
                                       .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                               if (location != null) {
                                   latitude = location.getLatitude();
                                   longitude = location.getLongitude();
                               }
                           }
                       }
                   }
               }
    
           } catch (Exception e) {
               e.printStackTrace();
           }
    
           return location;
       }
       
       //The statements allowing us to retrieve the values outwith the class.
      public double getLatitude(){
          if(location != null){
              latitude = location.getLatitude();
          }
           
          // return latitude
          return latitude;
      }
       
     
      public double getLongitude(){
          if(location != null){
              longitude = location.getLongitude();
          }
           
          // return longitude
          return longitude;
      }
      
      public boolean LocationAccesible() {
          return this.LocationAccesible;
      }
       
     
      
      public void stopUsingGPS(){
          if(locationManager != null){
              locationManager.removeUpdates(GetUserLoc.this);
          }       
      }
      
      //never used, but need to be used when implementing the location listner interface
    	   
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
