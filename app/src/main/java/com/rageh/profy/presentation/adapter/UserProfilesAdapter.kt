package com.rageh.profy.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rageh.profy.R
import com.rageh.profy.data.entity.UserProfile

class UserProfilesAdapter constructor() : ListAdapter<UserProfile, RecyclerView.ViewHolder>(object :
    DiffUtil.ItemCallback<UserProfile>() {
    override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile) =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile) =
        oldItem.toString() == newItem.toString()

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        object : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_profile, parent, false)
        ) {}

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
}