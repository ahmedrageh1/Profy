package com.rageh.profy.util

import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.RequiresApi
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


/**
 * Created by Ahmed on 2/25/2019.
 */

const val RESULT_CODE_DO_NOT_DISTURB = 100

@ActivityScoped
class PermissionsUtils @Inject constructor(
    @ApplicationContext private val context: Context,
    @ActivityContext private val activity: Context
) {

    private val nm: NotificationManager by lazy {
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun openAndroidPermissionsActivity() {
        val intent = Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS)
        intent.data = Uri.parse("package:${context.packageName}")
        activity.startActivity(intent)
    }

    fun checkIsDontDisturbPermissionGranted() = Build.VERSION.SDK_INT < Build.VERSION_CODES.M
            || nm.isNotificationPolicyAccessGranted

    @RequiresApi(Build.VERSION_CODES.M)
    fun requestDontDisturbPermission() {
        val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
        activity as Activity
        activity.startActivityForResult(intent, RESULT_CODE_DO_NOT_DISTURB)
    }


}