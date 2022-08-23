package edu.njit.littmanapp.ui.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class PoppinsSemiBold extends AppCompatTextView {
    public PoppinsSemiBold(Context context)
    {
        super(context);
        initTypeface(context);
    }

    public PoppinsSemiBold(Context context,
                          AttributeSet attrs)
    {
        super(context, attrs);
        initTypeface(context);
    }

    public PoppinsSemiBold(Context context,
                          AttributeSet attrs,
                          int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initTypeface(context);
    }

    private void initTypeface(Context context)
    {
        Typeface tf = Typeface.createFromAsset(
                context.getAssets(),
                "poppins_semi_bold.ttf");
        this.setTypeface(tf);
    }
}
