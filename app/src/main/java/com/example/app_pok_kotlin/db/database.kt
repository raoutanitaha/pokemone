package com.example.app_pok_kotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.app_pok_kotlin.models.Result

@Database(

    entities = [Result::class], version=1



)
   abstract   class database : RoomDatabase() {
    abstract fun pokemonDao() : pokemonDao

    companion object{
        var INSTANCE : database? = null

        fun getAppDatabase(context : Context) : database? {
            if(INSTANCE == null){
                synchronized(database::class){
                    INSTANCE = databaseBuilder(context.applicationContext, database::class.java,"database")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyDatabase(){
            INSTANCE = null
        }
    }
}