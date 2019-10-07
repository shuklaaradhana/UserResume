package com.resume.app.resume.view

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import com.resume.app.R
import com.resume.app.resume.callbacks.OnResumeCardClickListener
import com.resume.app.resume.data.UserProfile

class ResumeAdapter(val context: AppCompatActivity?, var resumeList: List<UserProfile>?) :
    RecyclerView.Adapter<ResumeAdapter.ResumeViewHolder>(), OnResumeCardClickListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResumeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.resume_list_view_holder, parent, false)

        return ResumeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResumeViewHolder, position: Int) {
        holder.binding.setVariable(BR.userResume, resumeList?.get(position))
        holder.binding.setVariable(BR.item, this)
    }

    override fun getItemCount(): Int {
        return resumeList?.size ?: 0
    }

    class ResumeViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onClick(userResume: UserProfile) {
        context?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragment_container, ResumeDetailsFragment(userResume))
            ?.addToBackStack(ResumeDetailsFragment::class.simpleName)?.commit()
    }
}