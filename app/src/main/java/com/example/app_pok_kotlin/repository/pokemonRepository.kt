package com.example.app_pok_kotlin.repository

import com.example.app_pok_kotlin.db.pokemonDao
import com.example.app_pok_kotlin.models.Result

class pokemonRepository(private val pokDAO: pokemonDao?) {


    val readALLdata: List<Result>? = pokDAO?.getPokemons()






}