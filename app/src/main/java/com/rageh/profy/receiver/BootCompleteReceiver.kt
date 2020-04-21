package com.rageh.profy.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootCompleteReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        //TODO handle startup tasks here
//        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        connectivityManager?.let {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                it.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
//                    override fun onAvailable(network: Network) {
//                        //take action when network connection is gained
//                    }
//                    override fun onLost(network: Network?) {
//                        //take action when network connection is lost
//                    }
//                })
//            }
//        }
    }
}