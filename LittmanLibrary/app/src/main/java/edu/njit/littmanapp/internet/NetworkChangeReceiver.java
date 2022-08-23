package edu.njit.littmanapp.internet;

import static edu.njit.littmanapp.internet.NetworkUtil.getConnectionStatus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import timber.log.Timber;

public class NetworkChangeReceiver extends BroadcastReceiver {

    public boolean isConnected = true;
    private String status;
    private IInternetConnectionListener iInternetConnectionListener;

    public NetworkChangeReceiver(IInternetConnectionListener iInternetConnectionListener) {
        this.iInternetConnectionListener = iInternetConnectionListener;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {

        status = NetworkUtil.getConnectivityStatusString();
        Timber.d("Internet Connection:" + status);

        if (getConnectionStatus()) {
            iInternetConnectionListener.haveInternetConnection();
        } else {
            iInternetConnectionListener.noInternetConnection();
        }


        if (status.equals("Not connected to Internet")) {

        }

    }


    public boolean is_connected() {
        return isConnected;
    }


    public interface IInternetConnectionListener {
        void haveInternetConnection();

        void noInternetConnection();
    }


}
