package com.resume.app.resume.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR
import com.resume.app.R
import com.resume.app.resume.data.UserExperience

class ResumeDetailsAdapter(private val userExperiences: List<UserExperience>?) :
    RecyclerView.Adapter<ResumeDetailsAdapter.UserExperienceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserExperienceViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.user_experience_view_holder, parent, false)

        return UserExperienceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserExperienceViewHolder, position: Int) {
        holder.binding.setVariable(BR.userExperience, userExperiences?.get(position))
    }

    override fun getItemCount(): Int {
        return userExperiences?.size ?: 0
    }

    class UserExperienceViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}