package com.example.kotlinpracticedemo

import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinpracticedemo.databinding.ActivityMainBinding
import com.example.kotlinpracticedemo.databinding.ActivityRoomMainBinding
import com.example.kotlinpracticedemo.repository.ContactRepository
import com.example.kotlinpracticedemo.room.Contact
import com.example.kotlinpracticedemo.room.ContactDatabase
import com.example.kotlinpracticedemo.viewmodel.ContactViewModel
import com.example.kotlinpracticedemo.viewmodel.ViewModelFactory

class RoomMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRoomMainBinding
    private lateinit var contactViewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_main)

        val dao = ContactDatabase.getInstance(this).contactDAO
        val repository = ContactRepository(dao)
        val factory = ViewModelFactory(repository)

        //ViewModel
        contactViewModel = ViewModelProvider(this, factory)[ContactViewModel::class.java]

        binding.contactViewModel = contactViewModel
        binding.lifecycleOwner = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        displayUserList()
    }

    private fun displayUserList() {
        contactViewModel.contacts.observe(this, Observer {
            binding.recycleView.adapter = MyRecyclerViewAdapter(it) { selectItem: Contact ->
                listItemClicked(selectItem)
            }
        })
    }

    private fun listItemClicked(selectItem: Contact) {
        Toast.makeText(
            this, "Selected name is ${selectItem.contact_name}",
            Toast.LENGTH_LONG
        ).show()

        contactViewModel.initUpdateAndDelete(selectItem)
    }
}