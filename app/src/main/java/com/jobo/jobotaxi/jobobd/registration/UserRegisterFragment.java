package com.jobo.jobotaxi.jobobd.registration;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jobo.jobotaxi.jobobd.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserRegisterFragment extends Fragment implements View.OnClickListener {

    private OnUserRegisterFragmentSelectedListener mCallback;
    private Button btnRegisterUser;
    private AppCompatTextView btnLogin;


    public UserRegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        mCallback.onRegisterFragmentSelect();
    }

    public void goToLogin(View view) {
        mCallback.onLoginSelect();


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnUserRegisterFragmentSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnUserRegisterFragmentSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_register, container, false);

        btnRegisterUser = view.findViewById(R.id.btnResetPassword);
        btnRegisterUser.setOnClickListener(this);

        btnLogin = view.findViewById(R.id.tvPasswordResetLink);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin(v);
            }
        });


        return view;
    }

    public interface OnUserRegisterFragmentSelectedListener {

        void onRegisterFragmentSelect();

        void onLoginSelect();
    }

}
