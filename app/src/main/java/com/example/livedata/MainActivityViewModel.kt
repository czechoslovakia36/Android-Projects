package com.example.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    var count = MutableLiveData<Int>()

    init{
        count.value=0
    }
    fun getUpdatedCount(){
        count.value= (count.value)?.plus(1)
    }

    fun getCurrentCount(): MutableLiveData<Int> {
        return count
    }
}