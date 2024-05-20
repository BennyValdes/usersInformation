package com.example.adptest.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.adptest.data.model.UserData
import com.example.adptest.databinding.UserCardBinding

class UsersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    private val binding = UserCardBinding.bind(itemView)

    fun render(userData: UserData, onClickListener: (UserData) -> Unit){
        Glide.with(binding.ivUserPhoto.context).load(userData.results?.component1()?.picture?.medium).into(binding.ivUserPhoto)
        binding.tvUserName.text = userData.results?.component1()?.name?.first
        binding.tvUserLast.text = userData.results?.component1()?.name?.last
        binding.tvEmails.text = userData.results?.component1()?.email
        binding.tvDob.text = userData.results?.component1()?.dob?.date
        binding.tvIdUser.text = userData.results?.component1()?.login?.username

        itemView.setOnClickListener { onClickListener(userData) }
    }

}