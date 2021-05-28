package com.example.recyclerview.advance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ListItemBinding

class RecyclerViewAdapter() : ListAdapter<User, RecyclerViewAdapter.ViewHolder>(CheckItems) {

    object CheckItems : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.rollNo == newItem.rollNo
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(val listItemBinding: ListItemBinding) : RecyclerView.ViewHolder(listItemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItemBinding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent ,false
        )
        return ViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.listItemBinding.rollNo.text = user.rollNo.toString()
        holder.listItemBinding.name.text = user.name
    }

}