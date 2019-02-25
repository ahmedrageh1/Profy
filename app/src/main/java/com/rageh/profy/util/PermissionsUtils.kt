package com.rageh.profy.util

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings


/**
 * Created by Ahmed on 2/25/2019.
 */
class PermissionsUtils {

    @TargetApi(Build.VERSION_CODES.M)
    fun openAndroidPermissionsActivity(context: Context) {
        val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
        intent.data = Uri.parse("package:${context.packageName}")
        context.startActivity(intent)
    }


}