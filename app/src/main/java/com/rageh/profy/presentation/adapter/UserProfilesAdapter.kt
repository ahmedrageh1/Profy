package com.rageh.profy.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rageh.profy.R
import com.rageh.profy.data.entity.FullUserProfile

class UserProfilesAdapter constructor() :
    ListAdapter<FullUserProfile, RecyclerView.ViewHolder>(object :
        DiffUtil.ItemCallback<FullUserProfile>() {
        override fun areItemsTheSame(oldItem: FullUserProfile, newItem: FullUserProfile) =
            oldItem.profile.id == newItem.profile.id


        override fun areContentsTheSame(oldItem: FullUserProfile, newItem: FullUserProfile) =
            oldItem.profile.toString() == newItem.profile.toString()

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_profile, parent, false)
        ) {}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}