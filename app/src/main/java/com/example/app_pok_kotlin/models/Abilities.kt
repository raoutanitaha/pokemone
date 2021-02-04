package com.example.app_pok_kotlin.models


import com.google.gson.annotations.SerializedName

data class Abilities(
    @SerializedName("hidden")
    val hidden: List<String>,
    @SerializedName("normal")
    val normal: List<String>
)