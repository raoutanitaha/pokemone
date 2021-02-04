package com.example.app_pok_kotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retrofitpokstats  {


    companion object{

        private var retrofit: Retrofit?=null
        private var BASE_URL ="https://pokeapi.glitch.me/v1"


        fun getretrofitresults(): Retrofit? {

            if(retrofit==null){

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()


            }
            return retrofit



        }







    }




}