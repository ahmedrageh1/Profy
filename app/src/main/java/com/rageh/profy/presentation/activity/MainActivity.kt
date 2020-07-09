package com.rageh.profy.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rageh.profy.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}