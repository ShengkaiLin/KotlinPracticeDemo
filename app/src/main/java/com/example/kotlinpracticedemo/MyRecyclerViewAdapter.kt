package com.example.kotlinpracticedemo

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpracticedemo.databinding.ActivityRoomMainBinding
import com.example.kotlinpracticedemo.databinding.CardItemBinding
import com.example.kotlinpracticedemo.room.Contact

class MyRecyclerViewAdapter(
    private val contactsList: List<Contact>,
    private val onItemClick: (Contact) -> Unit
) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact, onItemClick: (Contact) -> Unit) {
            binding.nameTextview.text = contact.contact_name
            binding.emailTextview.text = contact.contact_email
            binding.listItemLayout.setOnClickListener {
                onItemClick(contact)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: CardItemBinding = DataBindingUtil.inflate(
            layoutInflater, R.layout.card_item,
            parent, false
        )

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(contactsList[position], onItemClick)
    }
}