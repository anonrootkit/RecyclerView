package com.example.recyclerview.advance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AdvanceViewModel : ViewModel() {

    private val _list = MutableLiveData<List<User>>()
    val list : LiveData<List<User>>
        get() = _list

    init {
        _list.value = getList()
    }

    private fun getList() : List<User> {
        val list = ArrayList<User>()

        for (i in 0..20)
            list.add(User(rollNo = i, name = "Ankit:$i"))

        return list
    }

    class Factory : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AdvanceViewModel() as T
        }
    }
}

data class User(
    val rollNo : Int,
    val name : String,
)