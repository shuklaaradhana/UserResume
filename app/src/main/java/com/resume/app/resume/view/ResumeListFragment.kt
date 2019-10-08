package com.resume.app.resume.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.resume.app.R
import com.resume.app.resume.data.UserProfile
import com.resume.app.resume.data.repo.ResumeRequest
import com.resume.app.resume.vm.ResumeViewVmImpl
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ResumeListFragment : Fragment() {
    @Inject
    lateinit var resumeViewVm: ResumeViewVmImpl
    private lateinit var recyclerView: RecyclerView
    private var resumeList: List<UserProfile>? = null
    private val disposable = CompositeDisposable()
    private val adapter by lazy { ResumeAdapter(context = context as AppCompatActivity, resumeList = resumeList) }

    companion object {
        private const val REQUEST_URL = "https://gist.githubusercontent.com/shuklaaradhana/b6a19c0d2683bbc6f9b8e6111830f44c/raw/1d3d0681001bcc3284d467350e8a4502d7338ec5/resume_list.json/"

        @JvmStatic
        fun newInstance(): ResumeListFragment {
            return ResumeListFragment()
        }
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        disposable.add(
            resumeViewVm.getResumes(ResumeRequest(REQUEST_URL))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    println("success")
                    adapter.resumeList = it
                    adapter.notifyDataSetChanged()
                }, {
                    println("error in resume list ${it.cause}")
                })
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val view = inflater.inflate(
            R.layout.resume_list, container, false
        )
        recyclerView = view.findViewById(R.id.resume_list_recycler)

        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.dispose()
    }
}