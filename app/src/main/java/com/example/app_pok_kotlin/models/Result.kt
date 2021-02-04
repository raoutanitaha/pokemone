package com.example.app_pok_kotlin.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



@Entity(

    tableName="pokemone"

)

data class Result(


    @SerializedName("name")
    @PrimaryKey  val name: String,
    @SerializedName("url")
    val url: String

){

    fun getImageUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://pokeres.bastionbot.org/images/pokemon/$index.png"
        //return url
    }
}
