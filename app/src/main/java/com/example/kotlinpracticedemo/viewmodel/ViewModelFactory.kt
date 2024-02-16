package com.example.kotlinpracticedemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinpracticedemo.repository.ContactRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: ContactRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ContactViewModel::class.java)){
            return ContactViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown View Model Class")
    }
}