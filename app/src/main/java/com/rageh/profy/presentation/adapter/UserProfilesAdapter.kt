package com.rageh.profy.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.rageh.profy.BR
import com.rageh.profy.R
import com.rageh.profy.data.entity.FullUserProfile
import com.rageh.profy.databinding.ItemUserProfileBinding
import com.rageh.profy.presentation.base.BaseSimpleBindingAdapter
import com.rageh.profy.presentation.ui.home.HomeViewModel

class UserProfilesAdapter constructor(val viewModel: HomeViewModel?) :
    BaseSimpleBindingAdapter<FullUserProfile, ItemUserProfileBinding>(object :
        DiffUtil.ItemCallback<FullUserProfile>() {
        override fun areItemsTheSame(oldItem: FullUserProfile, newItem: FullUserProfile) =
            oldItem.profile.id == newItem.profile.id


        override fun areContentsTheSame(oldItem: FullUserProfile, newItem: FullUserProfile) =
            oldItem.profile.toString() == newItem.profile.toString()

    }) {

    override fun getItemLayout(viewType: Int) = R.layout.item_user_profile

    override fun onBindViewHolder(holder: ViewHolder<ItemUserProfileBinding>, position: Int) {
        holder.viewBinding.setVariable(BR.profile, getItem(position))
        holder.viewBinding.setVariable(BR.viewModel, viewModel)
        holder.viewBinding.executePendingBindings()
    }

}