package com.example.kotlinpracticedemo.repository

import com.example.kotlinpracticedemo.room.Contact
import com.example.kotlinpracticedemo.room.ContactDAO

class ContactRepository(private val contactDAO: ContactDAO) {

    val contacts = contactDAO.getAllContactsInDB()

    suspend fun insert(contact: Contact): Long {
        return contactDAO.insertContact(contact)
    }

    suspend fun delete(contact: Contact) {
        return contactDAO.deleteContact(contact)
    }

    suspend fun update(contact: Contact) {
        return contactDAO.updateContact(contact)
    }

    suspend fun deleteAll() {
        return contactDAO.deleteAll()
    }
}