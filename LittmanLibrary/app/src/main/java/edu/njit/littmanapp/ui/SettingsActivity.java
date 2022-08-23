package edu.njit.littmanapp.ui;

import static edu.njit.littmanapp.ui.helper.Constants.IS_DARK_MODE;
import static edu.njit.littmanapp.ui.helper.Constants.IS_LARGE_FONT;
import static edu.njit.littmanapp.ui.helper.Constants.LARGE_SIZE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;

import edu.njit.littmanapp.R;
import edu.njit.littmanapp.ui.about.AboutActivity;
import edu.njit.littmanapp.ui.helper.Constants;

public class SettingsActivity extends Activity {

    private LinearLayout layoutSettings;
    private RelativeLayout layoutTitle;
    private RelativeLayout layoutFontSize;
    private RelativeLayout layoutDarkMode;
    private RelativeLayout layoutAbout;
    private RelativeLayout layoutContact;

    private ImageView btnClose;
    private SwitchCompat btnLargeFont;
    private SwitchCompat btnDarkMode;

    private AppCompatTextView tvSettings;
    private AppCompatTextView tvLargeFont;
    private AppCompatTextView tvDarkMode;
    private AppCompatTextView tvAbout;
    private AppCompatTextView tvContactUs;

    SharedPreferences prefs;
    boolean isLargeFont;
    boolean isDarkMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnClose = findViewById(R.id.btn_close);

        layoutSettings = findViewById(R.id.layout_settings);
        layoutTitle = findViewById(R.id.layout_title);
        layoutFontSize = findViewById(R.id.layout_font_size);
        layoutDarkMode = findViewById(R.id.layout_dark_mode);
        layoutAbout = findViewById(R.id.layout_about);
        layoutContact = findViewById(R.id.layout_contact_us);

//        btnLargeFont = findViewById(R.id.swt_large_font);
//        btnDarkMode = findViewById(R.id.swt_dark_mode);

        tvSettings = findViewById(R.id.title_settings);
        tvLargeFont = findViewById(R.id.large_font);
        tvDarkMode = findViewById(R.id.dark_mode);
        tvAbout = findViewById(R.id.about);
        tvContactUs = findViewById(R.id.contact_us);

        prefs = getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);
        isLargeFont = prefs.getBoolean(IS_LARGE_FONT, false);
        isDarkMode = prefs.getBoolean(IS_DARK_MODE, false);
//        btnLargeFont.setChecked(isLargeFont);
//        btnDarkMode.setChecked(isDarkMode);

//        btnLargeFont.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                prefs.edit().putBoolean(IS_LARGE_FONT, isChecked).apply();
//                updateFontSize(isChecked);
//            }
//        });
//
//        btnDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                prefs.edit().putBoolean(IS_DARK_MODE, isChecked).apply();
//                updateMode(isChecked);
//            }
//        });

        layoutAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        layoutContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateFontSize(isLargeFont);
        updateMode(isDarkMode);
    }

    void updateFontSize(boolean isLarge) {
        tvSettings.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 28 + LARGE_SIZE : 28);
        tvLargeFont.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 16 + LARGE_SIZE : 16);
        tvDarkMode.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 16 + LARGE_SIZE : 16);
        tvAbout.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 16 + LARGE_SIZE : 16);
        tvContactUs.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 16 + LARGE_SIZE : 16);
    }

    void updateMode(boolean isDark) {
        layoutSettings.setBackgroundColor(getColor(isDark));
        layoutTitle.setBackgroundColor(getColor(isDark));
        layoutFontSize.setBackgroundColor(getColor(isDark, true));
        layoutDarkMode.setBackgroundColor(getColor(isDark, true));
        layoutAbout.setBackgroundColor(getColor(isDark, true));
        layoutContact.setBackgroundColor(getColor(isDark, true));

        tvSettings.setTextColor(getColor(!isDark));
        tvLargeFont.setTextColor(getColor(!isDark));
        tvDarkMode.setTextColor(getColor(!isDark));
        tvAbout.setTextColor(getColor(!isDark));
        tvContactUs.setTextColor(getColor(!isDark));

        btnClose.setImageResource(isDark ? R.drawable.ic_cancel_white : R.drawable.ic_cancel_black);
    }

    int getColor(boolean isDark) {
        return getColor(isDark, false);
    }

    int getColor(boolean isDark, boolean isCard) {
        return getResources().getColor(isDark ? (isCard ? R.color.card_background_dark_mode : R.color.screen_background_dark_mode) : R.color.colorWhite);
    }
}
