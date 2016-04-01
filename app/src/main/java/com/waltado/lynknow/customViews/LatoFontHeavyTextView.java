package com.waltado.lynknow.customViews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Aditya Rathi on 31-Mar-16.
 */
public class LatoFontHeavyTextView extends TextView {

    public LatoFontHeavyTextView(Context context) {
        super(context);
        init();
    }

    public LatoFontHeavyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LatoFontHeavyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "lato_heavy.ttf");
            setTypeface(tf);
        }

    }
}
