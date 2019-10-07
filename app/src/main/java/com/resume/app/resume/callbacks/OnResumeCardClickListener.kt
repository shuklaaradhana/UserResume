package com.resume.app.resume.callbacks

import com.resume.app.resume.data.UserProfile

interface OnResumeCardClickListener {
    fun onClick(userResume: UserProfile)
}