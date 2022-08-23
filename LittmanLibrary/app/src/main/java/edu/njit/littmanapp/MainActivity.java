package edu.njit.littmanapp;

import static edu.njit.littmanapp.ui.helper.Constants.IS_DARK_MODE;
import static edu.njit.littmanapp.ui.helper.Constants.LARGE_SIZE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.njit.littmanapp.ui.SettingsActivity;
import edu.njit.littmanapp.ui.helper.Constants;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    private DrawerLayout drawer;

    private BottomNavigationView bottomNavView;
    private CoordinatorLayout contentView;
    Toolbar toolbar;
    TextView textView;
    ImageView btnSettings;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(Constants.SHARED_PREFERENCE, Context.MODE_PRIVATE);

        initToolbar();
        initNavigation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean isLargeFont = prefs.getBoolean(Constants.IS_LARGE_FONT, false);
        boolean isDark = prefs.getBoolean(IS_DARK_MODE, false);

        updateFontSize(isLargeFont);
        updateDarkmode(isDark);
    }




    @Override
    public void onPause() {
        super.onPause();
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar_main);
        textView = findViewById(R.id.tv_title);
        btnSettings = findViewById(R.id.btn_settings);

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbar);
    }

    private void initNavigation() {
        drawer = findViewById(R.id.drawer_layout);
        bottomNavView = findViewById(R.id.bottom_nav_view);
        contentView = findViewById(R.id.content_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.bottom_home, R.id.bottom_search, R.id.bottom_services)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomNavView, navController);
        bottomNavView.setSelectedItemId(R.id.bottom_home);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                switch (destination.getId()) {
                    case R.id.bottom_home:
                        updateToolbarAndBottomNavigation("Home");
                        break;
                    case R.id.bottom_search:
                        updateToolbarAndBottomNavigation("Search");
                        break;
                    case R.id.bottom_services:
                        updateToolbarAndBottomNavigation("Services");
                        break;
                }
            }

        });
    }

    private void updateToolbarAndBottomNavigation(String title) {
        getSupportActionBar().setTitle("");
        textView.setText(title);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    void updateFontSize(boolean isLarge) {
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, isLarge ? 28 + LARGE_SIZE : 28);
    }

    void updateDarkmode(boolean isDark) {
        toolbar.setBackgroundColor(getColor(isDark));
        textView.setTextColor(getColor(!isDark));
        btnSettings.setImageResource(isDark ? R.drawable.menu_white : R.drawable.menu);
        bottomNavView.setBackgroundColor(getColor(isDark));
    }

    int getColor(boolean isDark) {
        return getResources().getColor(isDark ? R.color.screen_background_dark_mode : R.color.colorWhite);
    }
}
