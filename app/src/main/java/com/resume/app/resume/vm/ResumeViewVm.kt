package com.resume.app.resume.vm

import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.resume.app.resume.data.UserProfile
import com.resume.app.resume.data.repo.ResumeRequest
import io.reactivex.Single

abstract class ResumeViewVm : ViewModel() {
    abstract fun getResumes(resumeRequest: ResumeRequest): Single<List<UserProfile>>

    @RequiresApi(value = 21)
    abstract fun phoneFormatter(phoneNumber: String?): String?
}