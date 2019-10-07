package com.resume.app.resume.vm

import android.os.Build
import android.telephony.PhoneNumberUtils
import androidx.annotation.RequiresApi
import com.resume.app.resume.data.UserExperience
import com.resume.app.resume.data.repo.ResumeRequest
import com.resume.app.retrofit.ResumeApiService

open class ResumeViewVmImpl(private val resumeApiService: ResumeApiService) :
    ResumeViewVm() {

    override fun getResumes(resumeRequest: ResumeRequest) =
        resumeApiService.getResumes(resumeRequest.resumeRequestUrl)
            .map {
                it.sortedBy {
                    it.email
                }
            }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun phoneFormatter(phoneNumber: String?) = PhoneNumberUtils.formatNumber(phoneNumber, "US")

    fun sortUserExperiences(userExperiences: List<UserExperience>?) {
        userExperiences?.map { it.year.toInt() }?.sortedDescending()
    }
}
