package com.jobo.jobotaxi.jobobd.appStart;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.jobo.jobotaxi.jobobd.R;
import com.jobo.jobotaxi.jobobd.registration.RegisterActivity;

import java.util.Locale;


public class GettingStartedFragment extends Fragment {

    public static final String TAG = "GettingStartedFragment";
    private Button btnGetStarted;
    private Spinner spinner;
    private boolean isNewState;
    private View view;

    public GettingStartedFragment() {
        // Required empty public constructor
    }


    public static GettingStartedFragment newInstance() {
        GettingStartedFragment fragment = new GettingStartedFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            isNewState = true;
        } else {
            int S_INDEX = savedInstanceState.getInt("S_INDEX");
            if (S_INDEX > 0) {
                spinner = view.findViewById(R.id.spLang);
                spinner.setSelection(S_INDEX);
                Log.d(TAG, "onCreate: " + spinner.getSelectedItem().toString());
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_getting_started, container, false);

        spinner = view.findViewById(R.id.spLang);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.language_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Configuration config = new Configuration();
                switch (position) {
                    case 0:
                        config.locale = Locale.ENGLISH;
                        break;
                    case 1:
                        config.locale = Locale.ITALIAN;
                        break;
                    case 2:
                        config.locale = Locale.FRENCH;
                        break;
                    default:
                        config.locale = Locale.ENGLISH;
                        break;
                }
                getResources().updateConfiguration(config, null);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnGetStarted = view.findViewById(R.id.btnGetStarted);
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(registerIntent);
            }
        });
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        spinner = view.findViewById(R.id.spLang);
        int sIndex = spinner.getSelectedItemPosition();
        savedInstanceState.putInt("S_INDEX", sIndex);
    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }*/
    //change locale
    // @SuppressWarnings("deprecation")
   /* private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            configuration.setLocale(locale);
        } else{
            configuration.locale=locale;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            view.getContext().createConfigurationContext(configuration);
        } else {
            resources.updateConfiguration(configuration,displayMetrics);
        }
    }*/

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String lang= parent.getItemAtPosition(position).toString();

        if (lang == "English") {
            setLocale("en");
        } else if (lang == "Bengali") {
            setLocale("bn-rBD");
        } else if (lang == "Sinhala") {
            setLocale("si-rLK");
        } else {
            setLocale("en");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}
