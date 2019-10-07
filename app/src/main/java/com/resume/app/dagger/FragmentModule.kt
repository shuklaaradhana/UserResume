package com.resume.app.dagger

import com.resume.app.resume.view.ResumeDetailsFragment
import com.resume.app.resume.view.ResumeListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeResumeFragment(): ResumeDetailsFragment

    @ContributesAndroidInjector
    abstract fun contributeListFragment(): ResumeListFragment
}