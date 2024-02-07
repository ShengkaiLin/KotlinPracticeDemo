package com.example.kotlinpracticedemo.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract val contactDAO: ContactDAO

    //Singleton Design Pattern
    companion object {
        //原子操作標記(Sync 同步鎖定，以防多線程干擾)
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    //creating the database object
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactDatabase::class.java, "contacts_db"
                    ).build()
                }

                INSTANCE = instance

                return instance
            }
        }
    }

}