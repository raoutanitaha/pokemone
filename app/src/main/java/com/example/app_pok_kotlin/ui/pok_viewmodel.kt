package com.example.app_pok_kotlin.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.app_pok_kotlin.models.Result
import com.example.app_pok_kotlin.db.database
import com.example.app_pok_kotlin.repository.pokemonRepository
/*
class pok_viewmodel( application: Application): AndroidViewModel(application) {


    private val readAlldata:  LiveData<List<Result>>

    private val repository: pokemonRepository

    init{

   val pok_dao= database.getAppDatabase(application)?.pokemonDao()

     repository= pokemonRepository(pok_dao)

       readAlldata= repository.readALLdata
       }


}*/