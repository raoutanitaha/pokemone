package com.example.app_pok_kotlin.models


import com.google.gson.annotations.SerializedName

data class Family(
    @SerializedName("evolutionLine")
    val evolutionLine: List<String>,
    @SerializedName("evolutionStage")
    val evolutionStage: Int,
    @SerializedName("id")
    val id: Int
)

