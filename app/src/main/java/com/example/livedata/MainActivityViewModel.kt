package com.example.livedata

import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    private  var count =0
    fun getUpdatedCount():Int{
        return ++count
    }

    fun getCurrentCount():Int{
        return count
    }
}