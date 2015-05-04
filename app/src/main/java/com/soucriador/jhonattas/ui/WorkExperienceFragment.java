package com.soucriador.jhonattas.ui;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soucriador.jhonattas.R;

public class WorkExperienceFragment extends Fragment {

    public static WorkExperienceFragment newInstance() {
        WorkExperienceFragment fragment = new WorkExperienceFragment();
        return fragment;
    }

    public WorkExperienceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work_experience, container, false);
    }


}
