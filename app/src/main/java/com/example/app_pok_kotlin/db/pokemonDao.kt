package com.example.app_pok_kotlin.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.app_pok_kotlin.models.Result
import com.example.app_pok_kotlin.models.pokemone


@Dao
interface pokemonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPokemons( pokemon : List<Result>)

    @Update
    fun updatePokemon(pokemon : Result)

    @Delete
    fun deletePokemon(pokemon : Result)

    @Query("SELECT * FROM pokemone WHERE name == :name")
    fun getPokemonByName(name :  String) : LiveData<List<Result>>

    @Query("SELECT * FROM pokemone")
    fun getPokemons() : List<Result>
}