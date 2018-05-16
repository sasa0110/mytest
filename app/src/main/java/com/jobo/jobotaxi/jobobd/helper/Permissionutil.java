package com.jobo.jobotaxi.jobobd.helper;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by Tharaka on 2018-03-20.
 */

public class Permissionutil extends Application {

    public static final int MY_READ_PHONE_STATE = 2;
    public static final int MY_ACCESS_FINE_LOCATION = 3;
    public static int permissionall = 1;
    public static String[] permissionlist = {Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE};

    public static void haspermissionall(Activity context) {
        boolean permissionhave = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissionlist != null) {
            for (String Permission : permissionlist) {
                if (ActivityCompat.checkSelfPermission(context, Permission) != PackageManager.PERMISSION_GRANTED) {
                    permissionhave = false;
                }
            }
            if (permissionhave == false) {
                ActivityCompat.requestPermissions(context, permissionlist, permissionall);
            }

        }
    }


    public static boolean checkreadstatePermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, android.Manifest.permission.READ_PHONE_STATE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.READ_PHONE_STATE}, MY_READ_PHONE_STATE);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.READ_PHONE_STATE}, MY_READ_PHONE_STATE);
            }
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkLocationPermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            // Asking user if explanation is needed
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //Prompt the user once explanation has been shown
                ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_ACCESS_FINE_LOCATION);
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, MY_ACCESS_FINE_LOCATION);
            }
            return false;
        } else {
            return true;
        }
    }

}
