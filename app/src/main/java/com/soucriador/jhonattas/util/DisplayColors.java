package com.soucriador.jhonattas.util;

import android.text.Html;
import android.text.Spanned;

public class DisplayColors {

    public static Spanned twoColors(String first, String second){
        String text = "<font color=#323232>"+first+"</font> <font color=#DB3B4D>"+second+"</font>";
        return Html.fromHtml(text);

    }

}
