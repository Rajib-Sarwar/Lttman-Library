package edu.njit.littmanapp.internet;

import android.content.Context;

import edu.njit.littmanapp.app.EMSApp;

public interface AppController {
    static Context getAppContext() {
        return EMSApp.getAppContext();
    }
}
