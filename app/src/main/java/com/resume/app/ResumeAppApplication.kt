package com.resume.app

import android.app.Activity
import android.app.Application
import com.resume.app.dagger.DaggerResumeAppComponent
import com.resume.app.dagger.NetworkModule
import com.resume.app.dagger.ResumeAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class ResumeAppApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {
        lateinit var dagger: ResumeAppComponent

        private const val REQUEST_URL =
            "https://gist.githubusercontent.com/shuklaaradhana/b6a19c0d2683bbc6f9b8e6111830f44c/raw/1d3d0681001bcc3284d467350e8a4502d7338ec5/resume_list.json/"
    }

    override fun onCreate() {
        super.onCreate()
        DaggerResumeAppComponent.builder()
            .networkModule(NetworkModule(REQUEST_URL))
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}