package com.singlepointsol.retrofit

import com.google.gson.annotations.SerializedName

data class AlbumItem(
    @SerializedName("id")
    val id:Int,
    @SerializedName("userid")
    val userid:Int,
    @SerializedName("title")
    val title:String)
