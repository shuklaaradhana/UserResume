package com.resume.app.dagger

import com.resume.app.resume.vm.ResumeViewVmImpl
import com.resume.app.retrofit.ResumeApiService
import dagger.Module
import dagger.Provides

@Module
class ResumeModule {
    @Provides
    fun provideResumeViewVmImpl(resumeApiService: ResumeApiService): ResumeViewVmImpl {
        return ResumeViewVmImpl(resumeApiService)
    }
}