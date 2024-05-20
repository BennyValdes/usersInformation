package com.example.adptest.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adptest.R
import com.example.adptest.data.model.UserData

class UsersAdapter(private val usersList: List<UserData>, private val onClickListener:(UserData) -> Unit) : RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsersViewHolder(layoutInflater.inflate(R.layout.user_card,parent,false))
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val item = usersList[position]
        holder.render(item, onClickListener)
    }

    override fun getItemCount(): Int = usersList.size

}