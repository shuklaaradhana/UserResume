package com.resume.app.resume.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.resume.app.BR
import com.resume.app.R
import com.resume.app.resume.data.UserProfile
import com.resume.app.resume.vm.ResumeViewVmImpl
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ResumeDetailsFragment(private val userResume: UserProfile?) : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val resumeDetailsAdapter by lazy { ResumeDetailsAdapter(userResume?.experiences) }
    @Inject
    lateinit var resumeViewVmImpl: ResumeViewVmImpl

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        super.onCreateView(inflater, container, savedInstanceState)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.resume_details, container, false)
        binding.setVariable(BR.userResume, userResume)

        recyclerView = binding.root.findViewById(R.id.resume_details_recycler)
        initRecyclerView()
        initPhoneFormatter()

        resumeViewVmImpl.sortUserExperiences(userResume?.experiences)
        return binding.root
    }

    private fun initRecyclerView() {
        recyclerView.adapter = resumeDetailsAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun initPhoneFormatter() {
        val phoneNumber = userResume?.phoneNumber
        userResume?.phoneNumber = resumeViewVmImpl.phoneFormatter(phoneNumber)

    }
}