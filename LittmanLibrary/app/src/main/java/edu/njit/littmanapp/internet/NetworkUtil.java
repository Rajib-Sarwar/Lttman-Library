package edu.njit.littmanapp.internet;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus() {
        ConnectivityManager cm = (ConnectivityManager) AppController.getAppContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString() {
        int conn = NetworkUtil.getConnectivityStatus();
        String status = null;
        if (conn == NetworkUtil.TYPE_WIFI) {
            status = "Wifi enabled";
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            status = "Mobile data enabled";
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet";
        }
        return status;
    }



    public static boolean getConnectionStatus() {
        int conn = NetworkUtil.getConnectivityStatus();
        String status = null;
        if (conn == NetworkUtil.TYPE_WIFI) {
            return true;
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            return true;
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            return false;
        }else {
            return false;
        }
    }


}
