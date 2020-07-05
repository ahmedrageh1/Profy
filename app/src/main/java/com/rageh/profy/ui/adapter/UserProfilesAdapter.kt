package com.rageh.profy.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rageh.profy.R
import com.rageh.profy.model.entity.UserProfile
import com.rageh.profy.ui.adapter.viewholder.UserProfileViewHolder

class UserProfilesAdapter constructor() : ListAdapter<UserProfile, UserProfileViewHolder>(object :
    DiffUtil.ItemCallback<UserProfile>() {
    override fun areItemsTheSame(oldItem: UserProfile, newItem: UserProfile) =
        oldItem.id == newItem.id


    override fun areContentsTheSame(oldItem: UserProfile, newItem: UserProfile) =
        oldItem.toString() == newItem.toString()

}) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserProfileViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user_profile, parent, false)
    )

    override fun onBindViewHolder(holder: UserProfileViewHolder, position: Int) {

    }
}