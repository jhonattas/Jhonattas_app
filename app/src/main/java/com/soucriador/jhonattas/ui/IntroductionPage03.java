package com.soucriador.jhonattas.ui;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.soucriador.jhonattas.Main;
import com.soucriador.jhonattas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntroductionPage03#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IntroductionPage03 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private SharedPreferences sharedPreferences;
    public final String PREFS_PRIVATE = "CRIADOR_PREFS_PRIVATE";

    private Button introduction_accept;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IntroductionPage03.
     */
    // TODO: Rename and change types and number of parameters
    public static IntroductionPage03 newInstance(String param1, String param2) {
        IntroductionPage03 fragment = new IntroductionPage03();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public IntroductionPage03() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        final View rootview = inflater.inflate(R.layout.f_introduction_page03, container, false);

        // Inflate the layout for this fragment
        introduction_accept = (Button) rootview.findViewById(R.id.introduction_accept);
        introduction_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rootview.getContext(), Main.class));
                savePreferences();
                getActivity().finish();
            }
        });
        return rootview;
    }

    public void savePreferences(){
        boolean firstSee = false;
        sharedPreferences = getActivity().getSharedPreferences(PREFS_PRIVATE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("firstSee", firstSee);
        editor.commit();
    }

}
