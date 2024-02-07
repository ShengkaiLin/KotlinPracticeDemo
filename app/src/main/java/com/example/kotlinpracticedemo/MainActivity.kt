package com.example.kotlinpracticedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinpracticedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        counterViewModel = ViewModelProvider(this)[CounterViewModel::class.java]

        binding.lifecycleOwner = this
        binding.viewModel = counterViewModel
    }
}