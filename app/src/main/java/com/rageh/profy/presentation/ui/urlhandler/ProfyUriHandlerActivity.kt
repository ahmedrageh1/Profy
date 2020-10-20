package com.rageh.profy.presentation.ui.urlhandler

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rageh.profy.R
import com.rageh.profy.domain.profile.UserProfileHandler
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/*
* Profy data should be passes as the following standers
* scheme = profy
* host command
* json object data base64 encoded
* ex. profy://profile/encodedData
*/
@AndroidEntryPoint
class ProfyUriHandlerActivity : AppCompatActivity() {
    //TODO to be replaced with view model (clean code structure)
    @Inject
    lateinit var handler: UserProfileHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profy_uri_handler)
        intent.dataString?.let {
            Log.d("Intent Data=", it)
            handler.applyProfile(it).observe(this, {
                if (it) Toast.makeText(this, "Profile Activated", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
