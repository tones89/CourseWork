package com.denovan.anthony.coursework.ubi.mobile;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel.MapMode;
import java.security.Provider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.denovan.anthony.coursework.ubi.mobile.R.drawable;
import com.denovan.anthony.coursework.ubi.mobile.R.id;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.an;
import com.google.android.gms.internal.cu;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.ed;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.GroundOverlayOptionsCreator;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.R.string;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.p2p.WifiP2pManager.ActionListener;
import android.opengl.Visibility;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.AlarmClock;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.provider.Settings;
import android.provider.SyncStateContract.Constants;
import android.renderscript.Type;
import android.support.v4.app.TaskStackBuilder;

import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodSession;
import android.webkit.WebIconDatabase.IconListener;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint.Join;
import android.graphics.drawable.Drawable;

public class MainActivity extends Activity  {

	//=====================================================================================	
	//================================1.0 VENUES===========================================	
	//=====================================================================================	
	//define the latitude and longtitude of all the venues of the events
	// in Glasgow. We also create a location- in order to discover the venues address. 
	
	LatLng ll_Hamden = new LatLng(55.825703,-4.252386);
	Location hamp = MakeALocation(ll_Hamden.latitude,ll_Hamden.longitude);

	// Set up The venue variables. We create both a latitude and longditude, and a location.
	//this allows us to create markers, and also allows us 
	LatLng ll_Ibrox = new LatLng(55.853316,-4.308668);
	Location ibrox = MakeALocation(ll_Ibrox.latitude,ll_Ibrox.longitude);

	LatLng ll_StrathClydePark = new LatLng(55.785288,-4.014812);
	Location strathClydePark =  MakeALocation(ll_StrathClydePark.latitude,ll_StrathClydePark.longitude);

	LatLng ll_TollCross = new LatLng(55.845048,-4.176075);
	Location tollCross=  MakeALocation(ll_TollCross.latitude,ll_TollCross.longitude);

	LatLng ll_CathkinBraes = new LatLng(55.795495,-4.223294);
	Location cathkinBraes=  MakeALocation(ll_CathkinBraes.latitude,ll_CathkinBraes.longitude);

	LatLng ll_SECC = new LatLng(55.860914,-4.288986);
	Location sECC =  MakeALocation(ll_SECC.latitude,ll_SECC.longitude);

	LatLng ll_EmiratesArena = new LatLng(55.846847,-4.207008);
	Location emiratesArena    =  MakeALocation(ll_EmiratesArena.latitude,ll_EmiratesArena.longitude);

	LatLng ll_CelticPark = new LatLng(55.849593,-4.205547);
	Location  celtParl=  MakeALocation(ll_CelticPark.latitude,ll_CelticPark.longitude);

	LatLng ll_Scotstoun = new LatLng(55.881168,-4.340809);
	Location scotstoun    =  MakeALocation(ll_Scotstoun.latitude,ll_Scotstoun.longitude);

	LatLng ll_KelivnHall = new LatLng(55.867675,-4.289137);
	Location kelvinHall    =  MakeALocation(ll_KelivnHall.latitude,ll_KelivnHall.longitude);

	LatLng ll_GlasgowGreen = new LatLng(55.845109,-4.236656);
	Location glasgowGreen =  MakeALocation(ll_GlasgowGreen.latitude,ll_GlasgowGreen.longitude);

	LatLng ll_CommonWealthPool = new LatLng(55.939202,-3.172731);
	Location commonWealth = MakeALocation(ll_CommonWealthPool.latitude, ll_CommonWealthPool.longitude);
	//=====================================================================================	
	//=====================================================================================	
	//=====================================================================================	
	
	//The default location as per the spec- Glasgow
		LatLng Glasgow = new LatLng(55.865812,-4.256912);
	
	

	//=====================================================================================	
	//====================================Instance Vars====================================	
	//=====================================================================================		
	//An instance of the Google Map
	private GoogleMap googleMap; //Instance of the google map

	//A progress bar to show Progress of aSynchronous tasks
	ProgressDialog progDial;
	
	Location myLocation;
	Marker marker;
	
	//Used to determine which menu will be used
	boolean menuSwitch = false;  
	EditText et_GetAddress; //Edit text to allow user to enter text
	Button but_GetAddress;	//A button allowing the user to enter the options menu
	LatLng userLocale;	// A default latLng of the users location
	ProgressBar vw_AvtivityProgress;	//Used to show progress of asynchronous task
	TextView addressDisplay;	//text view used to display users address.
	final Context context1 = this;	//Define the applications context
	String[] snippets =new String[11]; //An array of snippets to store information about the markers	
	Button vw_FindUserButton;
	
	GetUserLoc userLocGetter;//Reference to the GPS class, which will be used to find the user. 
	
	//=====================================================================================	
	//====================================Radio Buttons====================================	
	//=====================================================================================	
	//The array of radio buttons useed throughout the app to switch between views, and
	//option menus etc.
	RadioButton pastLocations;
	RadioButton mapType;      
	RadioButton zoomToLoc;
	
	RadioButton DistanceFromHome;
	
	//=====================================================================================	
	//=====================================================================================	
	//=====================================================================================	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{    	
		super.onCreate(savedInstanceState);
		//LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		setContentView(R.layout.activity_main);

		
		googleMap=((MapFragment)getFragmentManager()	//defining the default view to the map fragment in the xml file
				.findFragmentById(R.id.map)).getMap();
					
		et_GetAddress = (EditText)findViewById(R.id.locEntry);
		et_GetAddress.setInputType(InputType.TYPE_CLASS_TEXT);
		SetupMarkers();
		but_GetAddress = (Button) findViewById(R.id.getLocButton);
		vw_FindUserButton = (Button)findViewById(R.id.gpsButton);
		vw_AvtivityProgress = (ProgressBar)findViewById(R.id.address_progress);
		addressDisplay = (TextView)findViewById(R.id.mAddressDisplay);
		addressDisplay.setTextColor(Color.MAGENTA);

		//Try the map initialisations within try catch to ensure app doesn't crash if map not found, or no location found.
		//one isn't found.
		try
		{
			InitializeMap();	//Initialise the overall map.	
			//	}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Toast.makeText(this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
		}

	}

	@Override 
	protected void onStart()
	{
		super.onStart();
	}
	
	//==============TThis method determines the users address,this====================
	//===============time we pass in the users GPS Coordinates and====================
	//==============Perform the opposite of the previous Async Task===================
	//==============So in theory, this is  reverse geolocation========================
	//==============This will display the users current location======================
	//==============On the bottom of the screen in an Text View=======================
	
	
	public void FindUser(View v)
	{
		userLocGetter = new GetUserLoc(getApplicationContext());	//retrieve a user location
		if(userLocGetter.LocationAccesible=true)	//If network services available.
			{
				Location usersLocation = userLocGetter.GetUserLocation();	//Retrieve GPS coordinates of the user
				getUserAddressBackwards reverseGeoCode = new getUserAddressBackwards();	//Create instance of reverse geocoding task
				reverseGeoCode.execute(usersLocation); //Pass this into the async task to reverse geocode these coordinates
				et_GetAddress.setText("");	//Set edit text to default
			}
	}
	
	
	//=====================================================================================	
	//====================================SWITCH MENUS=====================================	
	//=====================This Will be called whenever the user clicks on one of==========
	//=====================two Radio buttons. It determines which of the group ============
	//=====================Was clicked, and responds by setting the boolean to ============
	//=====================true or false, if false the menu will be the map type===========
	//=====================And if false, the past locations of the games will==============
	//======================================Displayed=====================================
	
	
	void MonitorChange()
	{
		RadioGroup menuSwitchButtGroup = (RadioGroup)findViewById(R.id.menuSwitch);	//Defining the radio group used to choose different menus


		mapType = (RadioButton)findViewById(R.id.rb_MapType);	//Radio button to switch to the Map_Type menu
		
		pastLocations = (RadioButton)findViewById(R.id.rb_PastLocations);	//Radio button to switch to past locations options.
		pastLocations.setTextColor(Color.CYAN);
		mapType.setTextColor(Color.CYAN);
	
		menuSwitchButtGroup.clearCheck();	//If any of the radio group is checked, uncheck it.
		
		//A listener to determine which of the radio buttons was clicked
		menuSwitchButtGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) //When the state of the radio group changes, this will be fired and action taken.
			{
				if(checkedId==mapType.getId())	//If the button was map type- change the options menu to be inflated to Map type
				{
					menuSwitch = false;
					
				}
				if(checkedId==pastLocations.getId())	//If the pastlocations button was checked, inflate the past locations menu
				{
					menuSwitch = true;
					
				}

			}
		});    		
	}

	
	
	//===============================================================================	
	//====================================MAIN METHOD================================	
	//===================This is essentially the main method of this application=====
	//===================The user inputs their home city, and is presented with======
	//===================A dialog box with several options pertaining to this.=======
	//===================The menu manages three choices, zoom to the given===========

	//===================Location, determine the distance between their home=========
	//===================OR find them using GPS. We iterate through these============
	//===================options using radio buttons and reverse/geolocation=========
	//===================and GPS positioning on background threads===================
	//======================================Displayed================================
	public void getAddress(View v) throws IOException

	{	//Declare an instance of a dialog box.
		final Dialog  dialog = new Dialog(context1);

		if(et_GetAddress.getText().toString().length() >1)	//A rudimentary means of checking the text box contains data, else it will cause errors.
		{
			//================================================================================
			//===============Setting the Basics of the dialog window==========================
			//================================================================================
			dialog.setContentView(R.layout.custom_dialogue); 
			dialog.setTitle("Map Options");
			Button cancelled = (Button)dialog.findViewById(R.id.Dialogue_Cancel);
			//================================================================================
			//================================================================================
			
			//================================================================================
			//===============Setting the Basics of the Radio Buttons==========================
			//===============Assigning the buttons and radio group to xml values==============
			//================================================================================
			RadioGroup radGroup = (RadioGroup)dialog.findViewById(R.id.LocationChoices);
			zoomToLoc = (RadioButton)dialog.findViewById(R.id.zoomToHomeCity);
			DistanceFromHome = (RadioButton)dialog.findViewById(R.id.DistanceFromhome);
			TextView titleOfGroup = (TextView)dialog.findViewById(R.id.Heading);	//Heading of the group to make it apparent.
			//================================================================================
			//================================================================================
			
			
			radGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener()	//Set up a listener onto the radio group to monitor change
			{

				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {	//once again fire off a listener when the radio button is pressed
					getUserAddress locateuserAddress = new getUserAddress();	//Instantiating the GPS class
					
					
					//==============The flesh of the code is within the following====================
					//===============Statements. The first determines if zoom to location=============
					//==============Has been selected, if so we display an update bar=================
					//==============dismiss the dialog and set the text view to default===============
					//==============It then calls an Async task on the given address =================
					//=====================And then zooms to this location============================
					if(checkedId == zoomToLoc.getId())
					{
						dialog.dismiss();	//dismiss the dialog box
						String  CityName = et_GetAddress.getText().toString();	//Retrieve the text fromt the text box
						if(CityName!=null)	//A second layer of protection, to ensure no errors.
						{
							vw_AvtivityProgress.setVisibility(View.VISIBLE);	// Show the progress bar
							locateuserAddress.execute(CityName);	//Execute the Async Task
							et_GetAddress.setText("");	//Reset the Text Box to default
						}
						else	//Otherwise return;
						{
							return;
						}
					}
					
					//==============TThis method determines distance from the users===================
					//===============Home town to Glasgow by determing GPS============================
					//==============coordinates of both. Thereafter, we call==========================
					//==============Distance between method of location, which========================
					//==============Retrieves distance in meters. Simple division=====================
					//==============Then determines the distance in miles=============================
					if(checkedId==DistanceFromHome.getId())
					{
						dialog.dismiss();
						String PassingString = et_GetAddress.getText().toString();
						LatLng HomeCity = locateuserAddress.doInBackground(PassingString);	//Retrieve the Coordinates of the entered city by calling the 
						//background task of async task
						
						float[] distance = new float[1];	//an array to hold results of distance calculation- we set it to hold one object- the distance,
						//A larger array can store information about bearings etc.
						Location.distanceBetween(HomeCity.latitude,HomeCity.longitude,Glasgow.latitude,Glasgow.longitude,distance);  //This method will retrieve the
						//distance between the two objects in metres.
						
						addressDisplay.setText("");	//Clear he Text view for clarity. 
						float totDistance = distance[0]/1609;	//Return the distance in miles by simply dividing by 1069 ( The amount of metres in a mile)
						addressDisplay.setText("Distance : "+"\n"+totDistance);
						//Toast.makeText(getApplicationContext(), "Distance : "+"\n"+totDistance, Toast.LENGTH_LONG).show();	//Display this as a toast message to the
						
						//user
						et_GetAddress.setText("");
					}
				}

			});

			//A button to shutDown the dialog box when it is clicked.
			cancelled.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) 

				{
					dialog.dismiss();
					et_GetAddress.setText("");
				}
			});


			dialog.show();	//Show the dialogue to the user. 

		}

		else
		{
			dialog.dismiss();	//If no city entered, close the dialouge; and inform the user that we need a city name. 
			Toast.makeText(getApplicationContext(), "Please enter a City",Toast.LENGTH_LONG).show();
		}
	}
	//==============This method will be used to draw the markers on the map================
	//==============of the various venues. It will make a call to the reverseGeo===========
	//===============Async task to retrieve the address of the venue=======================
	//===============And then define other parameters, and draw these======================
	//===============================on the map============================================
	void DrawMarkers()
	{
		
		getUserAddressBackwards reverGeo = new getUserAddressBackwards();
		//drawLocationMarker(ll_Hamden, "Hamden Park: "+"Athletics", reverGeo.doInBackground(hamp),R.drawable.running);
		drawLocationMarker(ll_Hamden, "Hamden Park: "+"Athletics",reverGeo.doInBackground(hamp),R.drawable.running);
		drawLocationMarker(ll_Ibrox, "Ibrox:  " +"Rugby 7's", reverGeo.doInBackground(ibrox),R.drawable.rugby);
		drawLocationMarker(ll_StrathClydePark, "StrathClyde Park: "+ "Triathalon", reverGeo.doInBackground(strathClydePark),R.drawable.triathalon);
		drawLocationMarker(ll_TollCross, "Tollcross: " +"Swimming", reverGeo.doInBackground(tollCross),R.drawable.swimming);
		drawLocationMarker(ll_CathkinBraes,"Cathkin Braes: "+" Mountain Biking", reverGeo.doInBackground(cathkinBraes),R.drawable.cycling);
		drawLocationMarker(ll_SECC, "SECC: "+" Boxing", reverGeo.doInBackground(sECC),R.drawable.boxing);
		drawLocationMarker(ll_EmiratesArena, "Emirates Arena: "+" Cycling/Badmington", reverGeo.doInBackground(emiratesArena),R.drawable.badmi_cyc);
		drawLocationMarker(ll_CelticPark, "Celtic Park: " + " Opening Ceremony", reverGeo.doInBackground(celtParl),R.drawable.openingceremony);
		drawLocationMarker(ll_Scotstoun, "Scotstoun: "+ " Squash/TableTennis", reverGeo.doInBackground(scotstoun),R.drawable.tbtennis);
		drawLocationMarker(ll_KelivnHall,"Kelivnhall: "+" Lawn Bowls", reverGeo.doInBackground(kelvinHall),R.drawable.bowls);
		drawLocationMarker(ll_GlasgowGreen, "Glasgow Green: "+" Hockey", reverGeo.doInBackground(glasgowGreen),R.drawable.hockey);
		drawLocationMarker(ll_CommonWealthPool, "CommonWealth Pool: "+ "Diving", reverGeo.doInBackground(commonWealth),R.drawable.diving);
	
	}

	
	
	//==============This method will be used to create a Location==============================
	//===============It takes a latitude and longditude and returns a location object	
	public Location MakeALocation(Double lat, Double longD)
	{
		Location defLoc = new Location("");	//Create a default location. The Provider argument can be anything we pass 
		//into it.
		defLoc.setLatitude(lat);
		defLoc.setLongitude(longD);
		return defLoc;
	}

	
	//==============Adding Snippets for the past location options ================
		
	void SetupMarkers()
	{
		//Adding the deault snippets to the snippets array. 
		snippets[0] = "Scotland Won 22 Medals ";
		snippets[1] = "Scotland Won 26 Medals ";
		snippets[2] = "Scotland Won 1 Medals";
		snippets[3] = "Scotland Won 26 Medals";
		snippets[4] = "Scotland Won 26 Medals ";
		snippets[5] = "Scotland Won 14 Medals";
		snippets[6] = " Scotland Won 12 Medals";
		snippets[7] = "Scotland Won  30 Medals";
		snippets[8] = "Scotland Won 29 Medals";
		snippets[9] = "Scotland Won 20 Medals ";

	}

	//Initialise the basic map, using basic if statements to check if the map
	//exists or not. 
	//if the map does not exist, we create it. 
	// if, it doesn't- then we show a toast to the user to inform them that the map wasnt found. 
	private void InitializeMap()	
	{
		//This will move the camera (the view) to zoom to Glasgow as the default
		//location as per the coursework spec. It takes the GPS Position of
		//Glasgow and zoom to a view of 12, which gives a fair view of the city
		googleMap.getUiSettings().setZoomControlsEnabled(false);
		googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Glasgow,12));
		// Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

		//The marker option for Glasgow, title being the name of the city,
		//and the snippet a small welcome note about Glasgow
		MarkerOptions markerOptions = new MarkerOptions()
		.title("Glasgow")
		.snippet("Welcome To Glasgow!\n Host of the Games")
		.position(Glasgow);


		//Add the initial marker which represents Glasgow on the map. 
		googleMap.addMarker(markerOptions);
		
		DrawMarkers();	//A call to the the draw marker method. 

		MonitorChange();	//Keeps track of the various view widget components in the user interface
		if(googleMap == null)
		{
			//if map doesnt exist, create it now.
			googleMap=((MapFragment)getFragmentManager()
					.findFragmentById(R.id.map)).getMap();

			//if it still doesnt exist, inform the user.
			if(googleMap ==null)
			{
				Toast.makeText(getApplicationContext(), 
						"Sorry no map!", Toast.LENGTH_LONG).show();
			}
		}

	}
	//==============This method will be used to inflate the====================
	//==============Menus, depending on which radio button=====================
	//==============has been selected by the user.Prepare======================
	//==============Options menu determines which menu=========================
	//=============is to be shown to the user depending========================
	//=============on the given boolean.
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		menu.clear(); //Clear view of previous menu

		MenuInflater inflater = getMenuInflater();
		if(menuSwitch==true)	//we use the boolean menuswitch to determine which is to be inflated. If true we inflate previous countries menu
		{
			menu.clear();	//clear the menu to ensure we don't pile two menus on top of another.
			inflater.inflate(R.menu.former_countries_layout, menu);	//inflte the menu from xml file
		}
		else	//Similar to before, however this time we inflate the map type menu
		{
			menu.clear();
			inflater.inflate(R.menu.main, menu);
		}
		return super.onPrepareOptionsMenu(menu);
	}

	//A method containing if else statements to determine, 
	//which item has been selected from the xml options file
	// which will change the map style/view respectively.
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		getUserAddress getadd = new getUserAddress();

		int itemId = item.getItemId();
		if (itemId == R.id.Hybrid) {
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID); // Setting the map to given view- in this case Hybrid
		} else if (itemId == R.id.Sattelite) {
			googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		} else if (itemId == R.id.Terrain) {
			googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
		} else if (itemId == R.id.Normal) {
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		} else if (itemId == R.id.Blank) {
			googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
			
			
		} else if (itemId == R.id.loc_Aukland) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String aukland = ChopString(R.id.loc_Aukland); // this will ensure we chop out the "loc_" part of the ID tag for the compontent. 
			getadd.execute(aukland);	//We firstly lookup the previously chopped address and then zoom to it.
			LatLng ll_Aukland1 = getadd.doInBackground(aukland);//and then get the coordinates of the city/
			drawLocationMarker(ll_Aukland1, aukland, snippets[0]); // call to the method which will draw the marker. It takes a title, a set of coordinates and a snippet.
		} else if (itemId == R.id.loc_Brisbane) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String brisb = ChopString(R.id.loc_Brisbane);
			getadd.execute(brisb);
			LatLng ll_Brisbane = getadd.doInBackground(brisb);
			drawLocationMarker(ll_Brisbane, brisb, snippets[1]);
		} else if (itemId == R.id.loc_Christchurch) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String chrstchurch = ChopString(R.id.loc_Christchurch);
			LatLng ll_ChristChurch = getadd.doInBackground(chrstchurch);
			drawLocationMarker(ll_ChristChurch, chrstchurch, snippets[2]);
			String chrstChurch = ChopString(R.id.loc_Christchurch);
			getadd.execute(chrstChurch);
		} else if (itemId == R.id.loc_Dehli) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String dehli = ChopString(R.id.loc_Dehli);
			LatLng ll_Dehli = getadd.doInBackground(dehli);
			drawLocationMarker(ll_Dehli, dehli, snippets[3]);
			getadd.execute(dehli);
		} else if (itemId == R.id.loc_Edinburgh) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String edinburgh = ChopString(R.id.loc_Edinburgh);
			LatLng ll_Edinburgh = getadd.doInBackground(edinburgh);
			drawLocationMarker(ll_Edinburgh, edinburgh, snippets[4]);
			getadd.execute(edinburgh);
		} else if (itemId == R.id.loc_Edmonton) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String edmonton = ChopString(R.id.loc_Edmonton);
			LatLng ll_Edmonton = getadd.doInBackground(edmonton);
			drawLocationMarker(ll_Edmonton, edmonton, snippets[5]);
			getadd.execute(edmonton);
		} else if (itemId == R.id.loc_KualaLumpur) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String kuala = ChopString(R.id.loc_KualaLumpur);
			LatLng ll_Kuala = getadd.doInBackground(kuala);
			drawLocationMarker(ll_Kuala, kuala, snippets[6]);
			getadd.execute(kuala);
		} else if (itemId == R.id.loc_Manchester) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String manchester = ChopString(R.id.loc_Manchester);
			LatLng ll_Manchester = getadd.doInBackground(manchester);
			drawLocationMarker(ll_Manchester, manchester, snippets[7]);
			getadd.execute(manchester);
		} else if (itemId == R.id.loc_Melbourne) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String melbourne = ChopString(R.id.loc_Melbourne);
			LatLng ll_Melbourne = getadd.doInBackground(melbourne);
			drawLocationMarker(ll_Melbourne, melbourne, snippets[8]);
			getadd.execute(melbourne);
		} else if (itemId == R.id.loc_Victoria) {
			vw_AvtivityProgress.setVisibility(View.VISIBLE);
			String victoria = ChopString(R.id.loc_Victoria);
			LatLng ll_Victoria = getadd.doInBackground(victoria);
			drawLocationMarker(ll_Victoria, victoria, snippets[9]);
			getadd.execute(victoria);
		} else {
			return super.onOptionsItemSelected(item);
		}
		return true;
	}

	
	//==============This method Will chop the given menu ================
	//==============id to return back just the name of the city==========

	private String ChopString(int ID)
	{
		String defString = getResources().getResourceEntryName(ID);

		int start = defString.indexOf("_");	//Start the chop after the underscore within the menu item. 
		String finalString = defString.substring(start+1);	//define the rest of the characters thereafter as the final string. 

		return finalString;//return the chopped string.
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		InitializeMap();
	}

	@Override
	protected void onStop() {
		googleMap.clear();
		super.onStop();
	}
	@Override
	protected void onPause() {
		super.onPause();

	}


	//==============This ASync task is used to locate the users location from the name of the city(String)========
	//==============It uses the geocoder in the background to return a list of locations based on the=============
	//==============Passed in string. It then returns a latitude and longitude(Address) which will be used========
	//==================================To zoom the map to the given coordinates On the UI thread=================
	private class getUserAddress extends
	AsyncTask<String,Void,LatLng>
	{

		@Override 
		protected LatLng doInBackground(String... strings)
		{
			Geocoder geocder = new Geocoder(getApplicationContext(),Locale.UK);//use uk locale to ensure better accuracy
			String CityName = strings[0];//get the first string from the passed in parameter

			List<Address>currAddress = null;	//define a list of Addresses 
			try
			{
				currAddress = geocder.getFromLocationName(CityName,1); //Use the geocoder class to lookup the cityname, which will return back an
				//address

			}
			catch (IOException e1)
			{
				Log.e("Get User Address ", "IO Exception In getUserAddress()");
				e1.printStackTrace();
			}

			if( currAddress !=null && currAddress.size()>0)//Check to ensure the list has data
			{

				Address address = currAddress.get(0);	//Make a new adress from the first item on the list.
				LatLng usersLoc = new LatLng(address.getLatitude(), address.getLongitude());	//Then use this to construct a latlng object ( needed to zoom map)
				return usersLoc; //then return this ( passed to onPostExecute.
			}
			else
			{
				return null;
			}

		}


		@Override
		protected void onPostExecute(LatLng userLoc)
		{
			vw_AvtivityProgress.setVisibility(View.GONE);// set the progress bar to invisible
			googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLoc, 14));//Zooms the map to the location attained in the background thread

		}
	}

	
	//==============This method is similar to the last Async task. However====================
	//==============This time the background thread will use the latitude=====================
	//==============and longitude to return an address from the geocoder class================
	//============== and then publish these results on the UI thread.=========================
	
	private class getUserAddressBackwards extends
	AsyncTask<Location,Void,String>
	{

		@Override 
		//This method will take in a collection of  locations, and using its latitude and longitude,
		//will return a string representing the address of the given location.
		protected String doInBackground(Location... locations)
		{
			Geocoder geocder = new Geocoder(getApplicationContext(),Locale.getDefault());
			Location loc = locations[0];	//use the first location in the list. 

			List<Address>currAddress = null;	//create an empty string to hold store the taken paramters
			try
			{
				//this is the computationally heavy method which requires an async task to achieve.
				//it uses the geocoder class to get an array of addresses from the latitude and longitude of
				//a location. We only look for 1 result, to keep accuracy high and computation low 
				currAddress = geocder.getFromLocation(loc.getLatitude(),loc.getLongitude(),1); 	
			}
			catch (IOException e1)
			{
				Log.e("Get User Address ", "IO Exception In getUserAddress()");
				e1.printStackTrace();
			}

			
			//only perform the following if the geocoder has returned a result, and populated the
			//list with an address
			if( currAddress !=null && currAddress.size()>0)
			{

				//This time we use the geocoder and address to consruct a string 
				//which will hold information about the address,
				//The three %s means that each of these %s will be replaced
				//by the three adress.get functions. 
				Address address = currAddress.get(0);
				String userAddress = String.format(
						"" +
						"%s, %s, %s"+
								// If there's a street address, add it
								"Address : ",
								address.getMaxAddressLineIndex() > 0 ?
										address.getAddressLine(0) : "",
										// Locality is usually a city
										address.getLocality(),
										// The country of the address
										address.getCountryName());

				return userAddress;
			}
			else
			{
				return "Sorry, No Address";
			}

		}


		@Override
		//once the heavy background computation has finished, we use the returned address
		//to update the UI thread. In this instance we first clear the text box to ensure
		//it is empty, hide the progress bar and update the text box with the returned address
		protected void onPostExecute(String address)
		{
			addressDisplay.setText("");//clear the text view, for clartity
			vw_AvtivityProgress.setVisibility(View.GONE);//hide the progress bar
			
			addressDisplay.setText(address);//set the text view to the users address 
		}
	}


	//==============This method will be used to draw the markers on the map================
	//==============It takes a location a title and a piece of ============================
	//==============information about the marker (Snippet)================================
	//====================================================================================
	public void drawLocationMarker(LatLng loc, String title, String snippet)
	{
		MarkerOptions Amarker = new MarkerOptions()
		.title(title)	//Set the title
		.position(loc)	//Set the Location
		.snippet(snippet);// Set the info

		googleMap.addMarker(Amarker); // draw the given marker on the map

	}
	
	
	//==============This method is the same as above, however this =======================
	//=============time we use use a custom marker to draw it on the map==================
	//====================================================================================
	public void drawLocationMarker(LatLng loc, String title, String snippet,int draw)
	{
		MarkerOptions Amarker = new MarkerOptions()
		.title(title)	//Set the title
		.position(loc)	//Set the Location
		.snippet(snippet)
		.icon(BitmapDescriptorFactory.fromResource(draw));
		googleMap.addMarker(Amarker); // draw the given marker on the map

	}
}
