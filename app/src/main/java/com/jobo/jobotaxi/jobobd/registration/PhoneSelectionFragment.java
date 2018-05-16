package com.jobo.jobotaxi.jobobd.registration;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jobo.jobotaxi.jobobd.R;
import com.jobo.jobotaxi.jobobd.helper.DBHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneSelectionFragment extends Fragment implements View.OnClickListener {

    private EditText edtPhoneNumber;
    private Button btnPhoneNumberSend;
    private String phone;
    private String IMEI;
    private DBHelper myDBHelper;
    private OnPhoneNumberSelectedListener mCallback;

    public PhoneSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        mCallback.onPhoneNumberSelect();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (OnPhoneNumberSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_phone_selection, container, false);

        edtPhoneNumber = view.findViewById(R.id.phone_number_edt);
        btnPhoneNumberSend = view.findViewById(R.id.btnPhoneNumberSend);

        btnPhoneNumberSend.setOnClickListener(this);

        return view;
    }

    public interface OnPhoneNumberSelectedListener {
        void onPhoneNumberSelect();
    }

}



