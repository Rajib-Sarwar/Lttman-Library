package edu.njit.littmanapp.ui.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class PoppinsBold extends AppCompatTextView {
    public PoppinsBold(Context context)
    {
        super(context);
        initTypeface(context);
    }

    public PoppinsBold(Context context,
                        AttributeSet attrs)
    {
        super(context, attrs);
        initTypeface(context);
    }

    public PoppinsBold(Context context,
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
                "poppins_bold.ttf");
        this.setTypeface(tf);
    }
}
