package com.jobo.jobotaxi.jobobd.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jobo.jobotaxi.jobobd.R;
import com.jobo.jobotaxi.jobobd.mainmap.MapsActivity;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener, PasswordResetFragment.OnFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginWithRestPassword();


    }


    @Override
    public void passwordResetToLogin() {
        loginWithRestPassword();
    }

    @Override
    public void gotoMap() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public void gotoPasswordReset() {
        PasswordResetFragment passwordResetFragment = new PasswordResetFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.loginContainer, passwordResetFragment)
                .addToBackStack(null)
                .commit();
    }

    public void loginWithRestPassword() {
        LoginFragment loginFragment = new LoginFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(null)
                .replace(R.id.loginContainer, loginFragment)
                .commitAllowingStateLoss();
    }
}
