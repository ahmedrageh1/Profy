package com.rageh.profy.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

//draft class
public class WifiBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.SUPPLICANT_STATE_CHANGED_ACTION.equals(action)) {
            SupplicantState state = intent.getParcelableExtra(WifiManager.EXTRA_NEW_STATE);
            if (SupplicantState.isValidState(state)
                    && (state == SupplicantState.COMPLETED || state == SupplicantState.DISCONNECTED)) {
                boolean connected = checkConnectedToDesiredWifi(context);
                Log.e("Rageh", "is connected" + state.toString());
            }
        }
    }

    /**
     * Detect you are connected to a specific network.
     */
    private boolean checkConnectedToDesiredWifi(Context context) {
        boolean connected = false;

        String desiredMacAddress = "Rageh";

        WifiManager wifiManager =
                (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        WifiInfo wifi = wifiManager.getConnectionInfo();
        if (wifi != null) {
            // get current router Mac address
            String bssid = wifi.getSSID();
            Log.e("ssid", bssid);
            connected = desiredMacAddress.equals(bssid);
        }

        return connected;
    }
}