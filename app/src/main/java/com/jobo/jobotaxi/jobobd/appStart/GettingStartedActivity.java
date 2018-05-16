package com.jobo.jobotaxi.jobobd.appStart;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.jobo.jobotaxi.jobobd.R;

public class GettingStartedActivity extends AppCompatActivity {

    private static final String TAG = "Getting Started";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_getting_started);


        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState != null) {
            // The fragment manager will handle restoring them if we are being
            // restored from a saved state
        } else {

            ViewGroup containerSelector = findViewById(R.id.startedContainer);
            if (containerSelector != null) {
                Log.i(TAG, "onCreate: adding ImageSelectorFragment to MainActivity");
                SplashFragment splashFragment = new SplashFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(containerSelector.getId(), splashFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startGettingStartedFragment();
            }
        }, 2000);
    }

    private void startGettingStartedFragment() {
        GettingStartedFragment startedFragment = new GettingStartedFragment();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.startedContainer, startedFragment);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

}
