package com.example.kotlinpracticedemo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    var counter = MutableLiveData<Int>()

    init {
        counter.value = 0
    }

    fun incrementCounter() {
        Log.d("TAG","hLLO")
        counter.value = counter.value?.plus(1)
    }

    fun getCurrentCounter(): Int? {
        return counter.value
    }


}