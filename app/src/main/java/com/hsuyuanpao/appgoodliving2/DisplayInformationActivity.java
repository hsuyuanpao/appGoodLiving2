package com.hsuyuanpao.appgoodliving2;


import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.hsuyuanpao.appgoodliving2.directionhelpers.FetchURL;
import com.hsuyuanpao.appgoodliving2.directionhelpers.TaskLoadedCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hsuyuanpao.appgoodliving2.MainActivity.i;

public class DisplayInformationActivity extends FragmentActivity implements OnMapReadyCallback, TaskLoadedCallback {
    private static final String TAG = "DisplayInfoActivity";
    private GoogleMap mMap;
    public MarkerOptions place1, place2, hodua, backpack;
    //Button getDirection;
    private Polyline currentPolyline;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private static boolean rLocationGranted = false;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private List<String> listlat;
    private List<String> listlng;
    public  List<Marker> markersList = new ArrayList<Marker>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_information);

        Toolbar toolbar = findViewById(R.id.toolbarTop);
        TextView textView = findViewById(R.id.toolbarTitle);
        ImageView imageView1 = findViewById(R.id.imviewTop1);
        ImageView imageView2 = findViewById(R.id.imviewTop2);

        String name = getIntent().getStringExtra("name");
        int no = getIntent().getIntExtra("no", 0);   // get location no.
        //Toast.makeText(this, "Information of no: " + no, Toast.LENGTH_SHORT).show();
        textView.setText(name);
        if(haveInternet()) {
            if (chkPlayService()) {
                initMap();
                if (rLocationGranted) {
                    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    mapFragment.getMapAsync(this);

                }

            }

        }
        else{
            /*Toast.makeText(DisplayInformationActivity.this
                    , "請開網路...", Toast.LENGTH_LONG).show();*/
            new AlertDialog.Builder(DisplayInformationActivity.this)
                    .setTitle("提醒")
                    .setMessage("手機網路未開，請至手機之設定功能選單，開啟網路!")
                    .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .show();
        }
        listlat = Arrays.asList(getResources().getStringArray(R.array.list_lat));
        listlng = Arrays.asList(getResources().getStringArray(R.array.list_lng));
        String la = listlat.get(no);
        Float lat = Float.parseFloat(la);
        String lg = listlng.get(no);
        Float lng = Float.parseFloat(lg);
        //place1 = new MarkerOptions().position(new LatLng(23.569478, 120.304146)).title("好住民宿 ");
        place2 = new MarkerOptions().position(new LatLng(lat, lng)).title(name);    //目的地名稱
        Log.d(TAG, "onCreate: place2 is ok...");

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(DisplayInformationActivity.this, InformationActivity.class);
                startActivity(intent1);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DisplayInformationActivity.this, MainActivity.class);
                startActivity(intent2);
            }
        });

            /*/ Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);*/
            //mMap.setMyLocationEnabled(true);
            //mMap.getUiSettings().setCompassEnabled(true); // 顯示指南針
            // mMap.getUiSettings().setZoomControlsEnabled(true);// 顯示縮放圖示

            /* CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new  LatLng(23.569478, 120.304146)) // 地圖的中心點
                .zoom(14) // 放大倍率
                .bearing(0) // 指南針旋轉 0 度
                .tilt(0) // 俯視的角度
                .build(); // 建立 CameraPosition 物件
            mMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));*/

        }

    private boolean haveInternet()
    {
        boolean result = false;
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=connManager.getActiveNetworkInfo();
        if (info == null || !info.isConnected())
        {
            result = false;
        }
        else
        {
            if (!info.isAvailable())
            {
                result =false;
            }
            else
            {
                result = true;
            }
        }

        return result;
    }

    private boolean chkPlayService(){
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(DisplayInformationActivity.this);
        if(available == ConnectionResult.SUCCESS){
            Log.d(TAG, "chkPlayService: is successful...");
            return true;
        }
        else{
            //Toast.makeText(this, "version does not match...", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "chkPlayService: is failed...");

            return false;
        }
    }

    private void initMap() {
        String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0]) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[1]) == PackageManager.PERMISSION_GRANTED) {
            //可以取得 fine location
            Log.d(TAG, "initMap: is granted...");
            rLocationGranted = true;
        }
        else{
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        rLocationGranted = false;
        switch (requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            rLocationGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: is not granted...");

                            return;
                        }
                    }
                    rLocationGranted = true;
                    Log.d(TAG, "onRequestPermissionsResult: is granted...");
                }
            }
        }
    }

   // }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Log.d("mylog", "Added Markers");

        getDeviceLocation();    //下列的工作都寫在 getDeviceLocation 中，不能寫在下面，可能是參數傳遞的問題!
        //place2 = new MarkerOptions().position(new LatLng(23.489474, 120.466244)).title("xxxxx ");
        //mMap.addMarker(place1);
        //mMap.addMarker(place2);
        //Log.d(TAG, "onMapReady: get place1 latlng: "+ place1.getPosition());
        //LatLng mLatLng = new  LatLng(23.569478, 120.304146);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(place1.getPosition()));
        //mMap.animateCamera(CameraUpdateFactory.zoomTo(13));


        //new FetchURL(DisplayInformationActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "driving"), "driving");
        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
    }

    private GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener =
            new GoogleMap.OnMyLocationButtonClickListener() {
                @Override
                public boolean onMyLocationButtonClick() {
                    //mMap.setMinZoomPreference(15);
                    getDeviceLocation();
                    // Toast.makeText(MapsActivity.this, "按返回鈕...", Toast.LENGTH_SHORT).show();
                    return false;
                }
            };

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.map_key_newest);
        return url;
    }

    @Override
    public void onTaskDone(Object... values) {
        if (currentPolyline != null)
            currentPolyline.remove();
        //Toast.makeText(this, "onTaskDone is performed... ", Toast.LENGTH_SHORT).show();
        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }

    private void getDeviceLocation(){
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        try{
            if(rLocationGranted){
                final Task location = mFusedLocationProviderClient.getLastLocation();
                location.addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            //找到目前位置
                            // Toast.makeText(MapsActivity.this, "定位完成...", Toast.LENGTH_SHORT).show();
                            Location mLocation = (Location) task.getResult();

                            //    Log.d(TAG, "getDeviceLocation: " + mLocation.getLatitude() +", "+mLocation.getLongitude());
                            Log.d(TAG, "getDeviceLocation: localization OK..."+mLocation.getLatitude()+" "+mLocation.getLongitude());
                            LatLng mLatLng = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
                            mMap.setMyLocationEnabled(true);    //致能返回目前位址小圖示
                            mMap.getUiSettings().setMyLocationButtonEnabled(true);
                            mMap.getUiSettings().setCompassEnabled(true); // 顯示指南針
                            mMap.getUiSettings().setZoomControlsEnabled(true);// 顯示縮放圖示
                            place1 = new MarkerOptions().position(mLatLng).title("目前位置 ");
                            Log.d(TAG, "getDeviceLocation: get place1 latlng: "+ place1.getPosition());
                            mMap.addMarker(place1);

                            //mMap.moveCamera(CameraUpdateFactory.newLatLng(mLatLng));
                            //mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng,13));

                            //place2 = new MarkerOptions().position(new LatLng(23.463234, 120.286120)).title("xxxxx");
                            mMap.addMarker(place2);
                            hodua = new MarkerOptions()
                                    .position(new LatLng(23.569478, 120.304146))
                                    .title("好住民宿")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
                            backpack = new MarkerOptions()
                                    .position(new LatLng(23.566283, 120.304764))
                                    .title("好住背包客棧")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));

                            mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(23.569478, 120.304146))
                                    .title("好住民宿")
                                    //.snippet("and snippet")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                            mMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(23.566283, 120.304764))
                                    .title("好住背包客棧")
                                    //.snippet("and snippet")
                                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

                            Marker p1 = mMap.addMarker(place1);
                            Marker p2 = mMap.addMarker(place2);
                            Marker hd = mMap.addMarker(hodua);
                            Marker bp = mMap.addMarker(backpack);

                            markersList.add(p1);    //目前位置
                            markersList.add(p2);    //景點位置
                            markersList.add(hd);    //好住民宿
                            markersList.add(bp);    //好住背包客棧

                            LatLngBounds.Builder builder = new LatLngBounds.Builder();
                            for (Marker marker : markersList) {
                                builder.include(marker.getPosition());
                            }

                           /* LatLngBounds bounds = builder.build();
                            CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 10);
                            mMap.moveCamera(cu);**/
                            /**initialize the padding for map boundary*/
                            int padding = 50;
                            /**create the bounds from latlngBuilder to set into map camera*/
                            LatLngBounds bounds = builder.build();
                            /*final int zoomWidth = getResources().getDisplayMetrics().widthPixels;
                            final int zoomHeight = getResources().getDisplayMetrics().heightPixels;*/
                            /**create the camera with bounds and padding to set into map*/
                            //final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, zoomWidth, zoomHeight,  padding);
                            final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,  padding);
                            new FetchURL(DisplayInformationActivity.this)
                                    .execute(getUrl(place1.getPosition(), place2.getPosition(), "walking"), "walking");

                            /**call the map call back to know map is loaded or not*/
                            //mMap.animateCamera(cu);
                            mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                                @Override
                                public void onMapLoaded() {
                                    /**set animated zoom camera into map*/
                                    mMap.animateCamera(cu);
                                }
                            });
                        }
                        else{
                            new AlertDialog.Builder(DisplayInformationActivity.this)
                                    .setTitle("提醒")
                                    .setMessage("手機定位未開，請至手機之設定功能選單，開啟定位功能!")
                                    /*.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                           finish();
                                        }
                                    })*/
                                    .setNegativeButton("確定",null)
                                    .show();
                        }
                    }
                });
            }
        }
        catch (SecurityException ex){
            Log.e(TAG, "getDeviceLocation: " + ex.getMessage());
        }
    }

/*    public void LastPage(View view){
        Intent intent = new Intent(this, InformationActivity.class);
        startActivity(intent);
    }

    public void HomePage(View view){
        Intent intent1 = new Intent(this, MainActivity.class);
        startActivity(intent1);
    }*/

}

/*
import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayInformationActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private GoogleMap mMap;
    ArrayList<LatLng> MarkerPoints;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();
        }
        // Initializing
        MarkerPoints = new ArrayList<>();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
*/
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
/*
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

        // Setting onclick event listener for the map
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {

                // Already two locations
                if (MarkerPoints.size() > 1) {
                    MarkerPoints.clear();
                    mMap.clear();
                }

                // Adding new item to the ArrayList
                MarkerPoints.add(point);

                // Creating MarkerOptions
                MarkerOptions options = new MarkerOptions();

                // Setting the position of the marker
                options.position(point);

                **
                 * For the start location, the color of marker is GREEN and
                 * for the end location, the color of marker is RED.


                if (MarkerPoints.size() == 1) {
                    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                } else if (MarkerPoints.size() == 2) {
                    options.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
                }


                // Add new marker to the Google Map Android API V2
                mMap.addMarker(options);

                // Checks, whether start and end locations are captured
                if (MarkerPoints.size() >= 2) {
                    LatLng origin = MarkerPoints.get(0);
                    LatLng dest = MarkerPoints.get(1);

                    // Getting URL to the Google Directions API
                    String url = getUrl(origin, dest);
                    Log.d("onMapClick", url.toString());
                    FetchUrl FetchUrl = new FetchUrl();

                    // Start downloading json data from Google Directions API
                    FetchUrl.execute(url);
                    //move map camera
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(origin));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(11));
                }

            }
        });

    }

    private String getUrl(LatLng origin, LatLng dest) {

        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;


        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + "AIzaSyANyVTSzPoNKh5xrjjbKtR4u88fMTkEiBg";


        return url;
    }
*/
    /**
     * A method to download json data from url
     */
/*
    private String downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            Log.d("downloadUrl", data.toString());
            br.close();

        } catch (Exception e) {
            Log.d("Exception", e.toString());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class FetchUrl extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... url) {

            // For storing data from web service
            String data = "";

            try {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
                Log.d("Background Task data", data.toString());
            } catch (Exception e) {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }
*/
    /**
     * A class to parse the Google Places in JSON format
     */
/*
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>> {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData) {

            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try {
                jObject = new JSONObject(jsonData[0]);
                Log.d("ParserTask",jsonData[0].toString());
                DataParser parser = new DataParser();
                Log.d("ParserTask", parser.toString());

                // Starts parsing data
                routes = parser.parse(jObject);
                Log.d("ParserTask","Executing routes");
                Log.d("ParserTask",routes.toString());

            } catch (Exception e) {
                Log.d("ParserTask",e.toString());
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result) {
            ArrayList<LatLng> points;
            PolylineOptions lineOptions = null;
            Log.d("onPostExecute","is starting...");

            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++) {
                points = new ArrayList<>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++) {
                    HashMap<String, String> point = path.get(j);

                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);

                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(10);
                lineOptions.color(Color.RED);

                Log.d("onPostExecute","onPostExecute lineoptions decoded");

            }

            // Drawing polyline in the Google Map for the i-th route
            if(lineOptions != null) {
                mMap.addPolyline(lineOptions);
                Log.d("onPostExecute","Polylines drawn");
            }
            else {
                Log.d("onPostExecute","without Polylines drawn");
            }
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("Current Position");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public boolean checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {

                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }

            // other 'case' lines to check for other permissions this app might request.
            // You can add here other case statements according to your requirement.
        }
    }
}
*/