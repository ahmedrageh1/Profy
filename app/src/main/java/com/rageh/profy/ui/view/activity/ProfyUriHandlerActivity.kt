package com.rageh.profy.ui.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rageh.profy.R

/*
* Profy data should be passes as the following standers
* scheme = profy
* host command
* json object data base64 encoded
* ex. profy://profile/encodedData
*/
class ProfyUriHandlerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profy_uri_handler)
        intent.dataString?.let {
            Log.d("Intent Data=", it)
        }
    }
}
