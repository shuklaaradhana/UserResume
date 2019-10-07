package com.resume.app

import com.resume.app.resume.data.Address
import com.resume.app.resume.data.UserExperience
import com.resume.app.resume.data.UserProfile
import com.resume.app.resume.data.repo.ResumeRequest
import com.resume.app.resume.vm.ResumeViewVmImpl
import com.resume.app.retrofit.ResumeApiService
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.spy
import org.mockito.MockitoAnnotations

class ResumeViewVmImplTest {

    private lateinit var resumeViewVmImpl: ResumeViewVmImpl
    @Mock
    lateinit var resumeApiService: ResumeApiService
    lateinit var resumeRequest: ResumeRequest
    private lateinit var userProfile1: UserProfile
    private lateinit var userProfile2: UserProfile
    private val resumeUrl =
        "https://gist.githubusercontent.com/shuklaaradhana/b6a19c0d2683bbc6f9b8e6111830f44c/raw/c0be8d6e8087935e39c6b5b45d6e9811672612af/resume_list.json"

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        resumeViewVmImpl = spy(ResumeViewVmImpl(resumeApiService))
        resumeRequest = ResumeRequest(resumeUrl)
    }

    @Test
    fun getResume_sortedBy_email() {
        initList()
        `when`(resumeApiService.getResumes(resumeUrl)).thenReturn(Single.just(unsortedList()))

        val testObserver = TestObserver<List<UserProfile>>()

        resumeViewVmImpl.getResumes(resumeRequest).subscribe(testObserver)


        testObserver.assertNoErrors()
        testObserver.assertValueAt(0, sortedList())
    }

    fun sortedList() = listOf(userProfile2, userProfile1)

    fun unsortedList() = listOf(userProfile1, userProfile2)

    fun initList() {
        userProfile1 = UserProfile(
            name = "Henry Ford",
            address = Address(streetName = "1314 The Alameda", city = "San Jose", postalCode = "94131"),
            email = "henryFord@gmail.com",
            phoneNumber = "5657689213",
            summary = "10 years experienced software developer",
            experiences = listOf(
                UserExperience(
                    company = "IBM",
                    year = "2000",
                    role = "Staff Sofware developer",
                    responsibility = "Taking care of the software development cycle and leading the team",
                    achievement = "Team player and star performer award"
                ),
                UserExperience(
                    company = "Microsoft",
                    year = "2014",
                    role = "Senior Software developer",
                    responsibility = "Leading the team",
                    achievement = "Star performer of the team"
                )
            )
        )

        userProfile2 = UserProfile(
            name = "aradhana shukla",
            address = Address(streetName = "34665 Allegheny Ct", city = "Fremont", postalCode = "94555"),
            email = "aradhanashukla86@gmail.com",
            phoneNumber = "7788005952",
            summary = "summary string",
            experiences = listOf(
                UserExperience(
                    company = "Pandora",
                    year = "2019",
                    role = "Software developer",
                    responsibility = "list of responsibility",
                    achievement = "list of achievements"
                ),
                UserExperience(
                    company = "Pandora1",
                    year = "2018",
                    role = "Software developer",
                    responsibility = "list of responsibility",
                    achievement = "list of achievements"
                )
            )
        )
    }
}