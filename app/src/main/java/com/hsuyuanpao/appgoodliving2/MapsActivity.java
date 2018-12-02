package com.hsuyuanpao.appgoodliving2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "MapsActivity";

    private GoogleMap mMap;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;
    private static boolean rLocationGranted = false;
    private FusedLocationProviderClient mFusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Toolbar toolbar = findViewById(R.id.toolBar4);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
        actionBar.setTitle("Google Map");

        Log.d(TAG,"onCreate: is preparing to run...");
        if(chkPlayService()){
            initMap();
            if(rLocationGranted){
                // Obtain the SupportMapFragment and get notified when the map is ready to be used.
                SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
                mapFragment.getMapAsync(this);
            }
        }
    }

    private void initMap() {
        String[] permissions = {Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        if(ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0]) == PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[1]) == PackageManager.PERMISSION_GRANTED) {
            //可以取得 fine location
            rLocationGranted = true;
        }
        else{
            ActivityCompat.requestPermissions(this, permissions, LOCATION_PERMISSION_REQUEST_CODE);
        }
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
                            mMap.addMarker(new MarkerOptions().position(mLatLng).title("目前位置"));
                           // mMap.moveCamera(CameraUpdateFactory.newLatLng(mLatLng));
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng,14));

                        }
                    }
                });

         /*       mFusedLocationProviderClient.getLastLocation().addOnCompleteListener(this, new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        if(task.isSuccessful()){
                            Location mLocation = task.getResult();

                            //    Log.d(TAG, "getDeviceLocation: " + mLocation.getLatitude() +", "+mLocation.getLongitude());
                            Log.d(TAG, "getDeviceLocation: localization OK..."+mLocation.getLatitude()+" "+mLocation.getLongitude());
                            LatLng mLatLng = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());

                            mMap.addMarker(new MarkerOptions().position(mLatLng).title("目前位置"));
                            // mMap.moveCamera(CameraUpdateFactory.newLatLng(mLatLng));
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mLatLng,10));
                        }
                    }
                });
                            */

            }
        }
        catch (SecurityException ex){
            Log.e(TAG, "getDeviceLocation: " + ex.getMessage());
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
                            return;
                        }
                    }
                    rLocationGranted = true;
                    // Map initialization
                }
            }
        }
    }

    private boolean chkPlayService(){
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MapsActivity.this);
        if(available == ConnectionResult.SUCCESS){
            Log.i(TAG, "chkPlayService: is successful...");
            return true;
        }
        else{
            Toast.makeText(this, "version does not match...", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
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

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        Log.d(TAG,"onMapReady: is preparing to run...");
        getDeviceLocation();

        mMap.setOnMyLocationButtonClickListener(onMyLocationButtonClickListener);
      //  mMap.setOnMyLocationClickListener(onMyLocationClickListener);


        //mMap.getUiSettings().setZoomControlsEnabled(true);
        //mMap.setMinZoomPreference(11);
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

/*    private GoogleMap.OnMyLocationClickListener onMyLocationClickListener =
            new GoogleMap.OnMyLocationClickListener() {
                @Override
                public void onMyLocationClick(@NonNull Location location) {

                    mMap.setMinZoomPreference(12);

                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(new LatLng(location.getLatitude(),
                            location.getLongitude()));

                    circleOptions.radius(200);
                    circleOptions.fillColor(Color.RED);
                    circleOptions.strokeWidth(6);

                    mMap.addCircle(circleOptions);
                }
            };*/
}