package com.resume.app.dagger

import com.resume.app.MainActivity
import com.resume.app.ResumeAppApplication
import com.resume.app.resume.view.ResumeDetailsFragment
import com.resume.app.resume.view.ResumeListFragment
import com.resume.app.resume.vm.ResumeViewVmImpl
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityModule::class, FragmentModule::class, NetworkModule::class, ResumeModule::class])
interface ResumeAppComponent : AndroidInjector<ResumeAppApplication> {
    override fun inject(application: ResumeAppApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: ResumeDetailsFragment)
    fun inject(fragment: ResumeListFragment)
    fun inject(resume: ResumeViewVmImpl)

}