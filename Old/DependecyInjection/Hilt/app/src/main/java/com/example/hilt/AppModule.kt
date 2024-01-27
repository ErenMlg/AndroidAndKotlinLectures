package com.example.hilt

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class AppModule {
    @Provides
    fun provideAdres():Adres{return Adres("Sultangazi/ISTANBUL")}
}