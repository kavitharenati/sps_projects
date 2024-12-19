package com.singlepointsol.api

import com.google.gson.annotations.SerializedName

data class Nature(
    @SerializedName("webformatURL")
    val natureImage: String,
    @SerializedName("user")
    val user: String,
    @SerializedName("views")
    val views: Int,
    @SerializedName("downloads")
    val downloads: Int,
    @SerializedName("likes")
    val likes: Int
)


data class NatureResponse(
    @SerializedName("hits")
    val hits: List<Nature>
)