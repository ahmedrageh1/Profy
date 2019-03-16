package com.rageh.profy.dagger.module

import android.content.Context
import android.media.AudioManager
import com.rageh.profy.dagger.ScopeApplication
import dagger.Module
import dagger.Provides

@Module
class AudioUtilsModule {
    @Provides
    @ScopeApplication
    fun getAudioManager(context: Context): AudioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
}