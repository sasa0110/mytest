package com.jobo.jobotaxi.jobobd.registration;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import com.jobo.jobotaxi.jobobd.R;
import com.jobo.jobotaxi.jobobd.login.LoginActivity;
import com.jobo.jobotaxi.jobobd.mainmap.MapsActivity;

public class RegisterActivity extends AppCompatActivity implements PhoneVerificationFragment.OnPhoneVerificationFragmentSelectedListener,
        PhoneSelectionFragment.OnPhoneNumberSelectedListener, UserRegisterFragment.OnUserRegisterFragmentSelectedListener {

    private static final String TAG = "RegisterActivity";
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState != null) {
            // The fragment manager will handle restoring them if we are being
            // restored from a saved state
        } else {

            ViewGroup containerSelector = findViewById(R.id.registerContainer);
            if (containerSelector != null) {
                Log.i(TAG, "onCreate: adding PhoneSelectorFragment to RegisterActivity");
                PhoneSelectionFragment phoneSelectionFragment = new PhoneSelectionFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(containerSelector.getId(), phoneSelectionFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }


    }


/*
    @Override
    public void phoneVerificationClickListener() {
        ViewGroup containerSelector = findViewById(R.id.registerContainer);
        if (containerSelector != null) {
            Log.i(TAG, "onCreate: adding PhoneSelectorFragment to RegisterActivity");
            PhoneVerificationFragment phoneVerificationFragment = new PhoneVerificationFragment();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(containerSelector.getId(), phoneVerificationFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }*/

    @Override
    public void onSelected() {

        UserRegisterFragment userRegisterFragment = new UserRegisterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction
                .replace(R.id.registerContainer, userRegisterFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onPhoneNumberSelect() {
        PhoneVerificationFragment phoneVerificationFragment = new PhoneVerificationFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction
                .replace(R.id.registerContainer, phoneVerificationFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onRegisterFragmentSelect() {
        /*UserRegisterFragment userRegisterFragment = new UserRegisterFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction
                .replace(R.id.registerContainer, userRegisterFragment)
                .addToBackStack(null)
                .commit();*/

        Intent intentMapActivity = new Intent(this, MapsActivity.class);
        startActivity(intentMapActivity);
    }

    @Override
    public void onLoginSelect() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
    }
}
