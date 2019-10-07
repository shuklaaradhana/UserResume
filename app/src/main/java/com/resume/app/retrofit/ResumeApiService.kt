package com.resume.app.retrofit

import com.resume.app.resume.data.UserProfile
import retrofit2.http.GET
import retrofit2.http.Url
import io.reactivex.Single
import retrofit2.http.Headers

interface ResumeApiService {
    @GET
    @Headers("Content-Type:application/json; charset=UTF-8")
    fun getResumes(@Url url: String): Single<List<UserProfile>>
}