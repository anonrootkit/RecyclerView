package com.example.recyclerview.another

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R

class AnotherAdapter(private val clickListener: OnClickListener) : RecyclerView.Adapter<AnotherAdapter.ViewHolder>() {

    private val dataList = ArrayList<String>()

    fun initlist2(list: List<String>){
        dataList.clear()
        dataList.addAll(list)
        this.notifyDataSetChanged()
    }

    class ViewHolder (view : View): RecyclerView.ViewHolder(view){
//        val textView : TextView = view.findViewById(R.id.value)
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): AnotherAdapter.ViewHolder {

        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnotherAdapter.ViewHolder, position: Int) {
//        holder.textView.text = dataList[position]
//        holder.textView.setOnClickListener{
//            clickListener.onItemClick(dataList[position])
//        }
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }
}