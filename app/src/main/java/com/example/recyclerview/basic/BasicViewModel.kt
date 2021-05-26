package com.example.recyclerview.basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BasicViewModel : ViewModel() {

    private val _list = MutableLiveData<List<String>>()
    val list : LiveData<List<String>>
        get() = _list

    init {
        _list.value = getList()
    }

    private fun getList() : List<String> {
        val list = ArrayList<String>()
        for (i in 1..20)
            list.add(i.toString())
        return list
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return BasicViewModel() as T
        }
    }
}