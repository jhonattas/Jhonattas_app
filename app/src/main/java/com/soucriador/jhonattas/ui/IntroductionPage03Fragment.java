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
import android.widget.TextView;

import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.util.DisplayColors;
import com.soucriador.jhonattas.util.RoundedImageView;

public class IntroductionPage03Fragment extends Fragment {

    private SharedPreferences sharedPreferences;
    public final String PREFS_PRIVATE = "CRIADOR_PREFS_PRIVATE";

    private RoundedImageView image;
    private TextView introduction_page_label;
    private Button introduction_page_button_accept;

    public static IntroductionPage03Fragment newInstance() {
        IntroductionPage03Fragment fragment = new IntroductionPage03Fragment();
        return fragment;
    }

    public IntroductionPage03Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootview  = inflater.inflate(R.layout.fragment_introduction_page, container, false);

        // define a imagem
        image = (RoundedImageView) rootview.findViewById(R.id.introduction_page_image);
        image.setImageResource(R.drawable.cube_criador);

        // define a descricao
        introduction_page_label = (TextView) rootview.findViewById(R.id.introduction_page_label);
        introduction_page_label.setText(DisplayColors.twoColors(getString(R.string.i_am), getString(R.string.creator)));

        // esconde o botao do layout
        introduction_page_button_accept = (Button) rootview.findViewById(R.id.introduction_page_button_accept);
        introduction_page_button_accept.setText(getString(R.string.explore));
        introduction_page_button_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(rootview.getContext(), SectionsActivity.class));
                //startActivity(new Intent(rootview.getContext(), CardAdapter.class));
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
