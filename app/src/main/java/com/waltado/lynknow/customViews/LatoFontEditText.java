package com.waltado.lynknow.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Aditya Rathi on 31-Mar-16.
 */
public class LatoFontEditText extends EditText {

    public LatoFontEditText(Context context) {
        super(context);
        init();
    }

    public LatoFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoFontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "lato_light.ttf");
            setTypeface(tf);
        }

    }
}
