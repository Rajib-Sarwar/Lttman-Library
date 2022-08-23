package edu.njit.littmanapp.ui.helper;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class PoppinsMedium extends AppCompatTextView {
    public PoppinsMedium(Context context)
    {
        super(context);
        initTypeface(context);
    }

    public PoppinsMedium(Context context,
                        AttributeSet attrs)
    {
        super(context, attrs);
        initTypeface(context);
    }

    public PoppinsMedium(Context context,
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
                "poppins_medium.ttf");
        this.setTypeface(tf);
    }
}
