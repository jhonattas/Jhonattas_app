package com.soucriador.jhonattas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.util.RoundedImageView;
import com.soucriador.jhonattas.util.DisplayColors;

public class IntroductionPage02Fragment extends Fragment implements Animation.AnimationListener {

    private RoundedImageView image;
    private TextView introduction_page_label;
    private Button introduction_page_button_accept;
    private Animation fadeIn;

    public static IntroductionPage02Fragment newInstance() {
        IntroductionPage02Fragment fragment = new IntroductionPage02Fragment();
        return fragment;
    }

    public IntroductionPage02Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview  = inflater.inflate(R.layout.fragment_introduction_page, container, false);

        // define a imagem
        image = (RoundedImageView) rootview.findViewById(R.id.introduction_page_image);
        image.setImageResource(R.drawable.cube_jhonn_flat);

        // esconde o botao do layout
        introduction_page_button_accept = (Button) rootview.findViewById(R.id.introduction_page_button_accept);
        introduction_page_button_accept.setVisibility(LinearLayout.GONE);

        // define e inicia a animação da imagem
        fadeIn = AnimationUtils.loadAnimation(rootview.getContext(), R.anim.fade_in);
        fadeIn.setAnimationListener(this);
        image.startAnimation(fadeIn);

        // define a descricao
        introduction_page_label = (TextView) rootview.findViewById(R.id.introduction_page_label);
        introduction_page_label.setText(DisplayColors.twoColors(getString(R.string.i_am), getString(R.string.aspiring_design)));

        return rootview;
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


}
