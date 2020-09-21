package com.rageh.profy.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import com.rageh.profy.presentation.activity.MainActivity
import com.rageh.profy.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private val viewModel: SplashViewModel by viewModels()
    private val backgroundThreadDispatcher by lazy {
        Executors.newSingleThreadExecutor { task ->
            Thread(task, "background-delayed-thread")
        }.asCoroutineDispatcher()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            whenStarted {
                viewModel.defaultProfile.observe(this@SplashActivity, {
                    if (it == null) {
                        viewModel.initDefaultProfile()
                            .observe(this@SplashActivity, { delayAndStart() })
                    } else {
                        delayAndStart()
                    }
                })
            }
        }

    }

    private fun delayAndStart() {
        lifecycleScope.launch(backgroundThreadDispatcher) {
            delay(1000)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }


}
