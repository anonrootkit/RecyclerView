package com.example.recyclerview.basic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    private val dataList = ArrayList<String>()

    fun initList(list: List<String>) {
        dataList.clear()
        dataList.addAll(list)
        this.notifyDataSetChanged()
    }

    class ViewHolder(listItemView : View) : RecyclerView.ViewHolder(listItemView) {
//        val valueTextView : TextView = listItemView.findViewById(R.id.value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listItemView : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(listItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.valueTextView.text = dataList[position]
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}