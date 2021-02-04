package com.example.app_pok_kotlin.network
import com.example.app_pok_kotlin.models.Family
import com.example.app_pok_kotlin.models.POKE_det
import com.example.app_pok_kotlin.models.POKE_detItem
import com.example.app_pok_kotlin.models.pokemone
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface pokservoce {

    @GET("pokemon")

    fun getinformation(
            @Query("limit") limit: Int ,
            @Query("offset") offset: Int
    ): Call<pokemone>


   @GET("pokemon/{name}")
    fun fetchPokemonDetails(
       @Path("name")
       name : String) : Call<POKE_det>
    @GET("pokemon/{name}")
    fun fetchPokemonevolutions(
        @Path("name")
        name : String) : Call<POKE_detItem>
}