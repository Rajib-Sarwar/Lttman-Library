package edu.njit.littmanapp.app;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.multidex.MultiDex;

import timber.log.Timber;

public class EMSApp extends Application {
    private static Context context;

    public static Context getAppContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //MultiDex.install(this);
        LogUtil.initializeLog("EMS_LOG");
        Timber.d("App Create");
    }

    public static void toastify(String message) {
        Toast.makeText(getAppContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {

        Timber.d("onLowMemory");
        super.onLowMemory();
    }


    @Override
    public void onTerminate() {
        Timber.d("onTerminate");
        super.onTerminate();

    }
}
