package com.example.app_pok_kotlin.models


import com.google.gson.annotations.SerializedName

data class POKE_detItem(
    @SerializedName("abilities")
    val abilities: Abilities,
    @SerializedName("description")
    val description: String,
    @SerializedName("eggGroups")
    val eggGroups: List<String>,
    @SerializedName("family")
    val family: Family,
    @SerializedName("gen")
    val gen: Int,
    @SerializedName("gender")
    val gender: List<Double>,
    @SerializedName("height")
    val height: String,
    @SerializedName("legendary")
    val legendary: Boolean,
    @SerializedName("mega")
    val mega: Boolean,
    @SerializedName("mythical")
    val mythical: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("sprite")
    val sprite: String,
    @SerializedName("starter")
    val starter: Boolean,
    @SerializedName("types")
    val types: List<String>,
    @SerializedName("ultraBeast")
    val ultraBeast: Boolean,
    @SerializedName("weight")
    val weight: String
) {

    fun getImageUrl(): String {
        val index = sprite
        return index
        //return url
    }



}
