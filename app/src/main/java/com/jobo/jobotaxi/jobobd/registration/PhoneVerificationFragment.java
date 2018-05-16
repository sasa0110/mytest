package com.jobo.jobotaxi.jobobd.registration;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jobo.jobotaxi.jobobd.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneVerificationFragment extends Fragment implements View.OnClickListener {

    private OnPhoneVerificationFragmentSelectedListener mCallback;
    private Button btnSendCode;

    public PhoneVerificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        mCallback.onSelected();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone_verification, container, false);

        btnSendCode = view.findViewById(R.id.btnCodeVerify);
        btnSendCode.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnPhoneVerificationFragmentSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnHeadlineSelectedListener");
        }


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public interface OnPhoneVerificationFragmentSelectedListener {
        void onSelected();
    }

}
