package com.jobo.jobotaxi.jobobd.appStart;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jobo.jobotaxi.jobobd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {


    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        ImageView ivlogo = view.findViewById(R.id.iv_logo);

        AnimatorSet set = (AnimatorSet) AnimatorInflater
                .loadAnimator(getActivity(), R.animator.logo_animation);
        set.setTarget(ivlogo);
        set.start();

        return view;
    }

}
