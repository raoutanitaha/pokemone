package com.example.app_pok_kotlin.models


import com.google.gson.annotations.SerializedName

data class pokemone(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<Result>
)