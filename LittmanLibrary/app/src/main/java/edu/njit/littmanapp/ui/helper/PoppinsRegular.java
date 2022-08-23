package edu.njit.littmanapp.ui.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class PoppinsRegular extends AppCompatTextView {
    public PoppinsRegular(Context context)
    {
        super(context);
        initTypeface(context);
    }

    public PoppinsRegular(Context context,
                          AttributeSet attrs)
    {
        super(context, attrs);
        initTypeface(context);
    }

    public PoppinsRegular(Context context,
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
                "poppins_regular.ttf");
        this.setTypeface(tf);
    }
}
