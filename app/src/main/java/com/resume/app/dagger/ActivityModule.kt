package com.resume.app.dagger

import com.resume.app.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeActivityInjector(): MainActivity
}