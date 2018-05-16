package com.jobo.jobotaxi.jobobd.helper;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jobo.jobotaxi.jobobd.R;

/**
 * Created by Tharaka on 2018-03-12.
 */

public class GlobalVal {

    //For check permissions
    public static final int MY_READ_PHONE_STATE = 99;
    public static final int MY_ACCESS_FINE_LOCATION = 100;
    public static final int MY_ACCESS_COARSE_LOCATION = 101;
    public static String Mainurl = "http://arrowcablk.com/new";
    //public static String Mainurl = "http://arrowcablk.com/new";
    public static String imeino;
    public static boolean first_trigger = false;

    public static String getdeviceIMEI(Activity activity) {
        if (Permissionutil.checkreadstatePermission(activity) == true) {
            TelephonyManager telMgr = (android.telephony.TelephonyManager) activity.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
            imeino = telMgr.getDeviceId();
            return imeino;
        }
        return "";
    }

    public static void showGpsDisabledDialog(final Context context) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);
        TextView txttitle = dialogView.findViewById(R.id.dialogtitle);
        TextView txtmessage = dialogView.findViewById(R.id.dialogmessage);
        txttitle.setText(R.string.gps_permission_title);
        txtmessage.setText(R.string.gps_permission_messege);
        // Add action buttons
        builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                return;
            }
        });
        builder.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                System.exit(0);
                builder.setCancelable(true);
            }
        });
        builder.create();
        builder.show();
    }

    public static void showOkDialogue(final Context context, String Title, String Message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);
        TextView txttitle = dialogView.findViewById(R.id.dialogtitle);
        TextView txtmessage = dialogView.findViewById(R.id.dialogmessage);
        txttitle.setText(Title);
        txtmessage.setText(Message);
        // Add action buttons
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                return;
            }
        });
        builder.create();
        builder.show();
    }

    public static void showPermissionDialogue(final Activity activity, String Title, String Message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = LayoutInflater.from(activity);
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(dialogView);
        builder.setCancelable(false);
        TextView txttitle = dialogView.findViewById(R.id.dialogtitle);
        TextView txtmessage = dialogView.findViewById(R.id.dialogmessage);
        txttitle.setText(Title);
        txtmessage.setText(Message);
        // Add action buttons
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_PHONE_STATE}, MY_READ_PHONE_STATE);
            }
        });
        builder.create();
        builder.show();
    }
}
