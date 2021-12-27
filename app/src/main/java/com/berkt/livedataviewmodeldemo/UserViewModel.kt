package com.berkt.livedataviewmodeldemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel: ViewModel() {
    var userId = 1
    var listOfUsers = mutableListOf<UserData>()

    // LiveData
    val currentUsers: MutableLiveData<List<UserData>> by lazy {
        MutableLiveData<List<UserData>>()
    }
}