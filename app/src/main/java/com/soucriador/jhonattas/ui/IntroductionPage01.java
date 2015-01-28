package com.soucriador.jhonattas.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.soucriador.jhonattas.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IntroductionPage01#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IntroductionPage01 extends Fragment implements Animation.AnimationListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ImageView image;
    private Animation fadeIn;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IntroductionPage01.
     */
    // TODO: Rename and change types and number of parameters
    public static IntroductionPage01 newInstance(String param1, String param2) {
        IntroductionPage01 fragment = new IntroductionPage01();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public IntroductionPage01() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        //image.startAnimation(fadeIn);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview  = inflater.inflate(R.layout.f_introduction_page01, container, false);
        // Inflate the layout for this fragment
        image = (ImageView) rootview.findViewById(R.id.indroduction_image_pg1);
        fadeIn = AnimationUtils.loadAnimation(rootview.getContext(), R.anim.fade_in);
        fadeIn.setAnimationListener(this);
        image.startAnimation(fadeIn);
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
