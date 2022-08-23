package edu.njit.littmanapp.ui.about;

import static edu.njit.littmanapp.ui.helper.Constants.IS_DARK_MODE;
import static edu.njit.littmanapp.ui.helper.Constants.IS_LARGE_FONT;
import static edu.njit.littmanapp.ui.helper.Constants.LARGE_SIZE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import edu.njit.littmanapp.R;
import edu.njit.littmanapp.ui.SettingsActivity;
import edu.njit.littmanapp.ui.helper.Constants;

public class AboutActivity extends Activity {

    private Toolbar toolbar;
    LinearLayout linear_layout;
    TextView aboutTextView;
    TextView textView;
    ImageView btnSettings;
    SharedPreferences prefs;
    boolean isLargeFont;
    boolean isDarkMode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        toolbar = findViewById(R.id.toolbar);
        textView = toolbar.findViewById(R.id.tv_app_bar_title);
        linear_layout = findViewById(R.id.linear_layout);
        aboutTextView = findViewById(R.id.about_text);
        textView.setText("About");
        btnSettings = findViewById(R.id.btn_settings);

        prefs = getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        isLargeFont = prefs.getBoolean(IS_LARGE_FONT, false);
        isDarkMode = prefs.getBoolean(IS_DARK_MODE, false);
        updateDarkmode();
        updateFontSize();
    }

    void updateDarkmode() {
        toolbar.setBackgroundColor(getColor(isDarkMode));
        btnSettings.setImageResource(isDarkMode ? R.drawable.menu_white : R.drawable.menu);
        textView.setTextColor(getColor(!isDarkMode));
        linear_layout.setBackgroundColor(getColor(isDarkMode));
        aboutTextView.setTextColor(getColor(!isDarkMode));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(!isDarkMode ? R.color.screen_background_dark_mode : R.color.screen_background_light_mode), PorterDuff.Mode.SRC_ATOP);
    }

    int getColor(boolean isDark) {
        return getResources().getColor(isDark ? R.color.screen_background_dark_mode : R.color.colorWhite);
    }

    void updateFontSize() {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLargeFont ? 28 + LARGE_SIZE : 28);
        aboutTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLargeFont ? 18 + LARGE_SIZE : 18);
    }
}