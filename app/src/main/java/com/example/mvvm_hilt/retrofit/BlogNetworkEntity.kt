package com.example.mvvm_hilt.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BlogNetworkEntity(
    // model exculive only for retrofit
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("username")
    @Expose
    var username: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("website")
    @Expose
    var website: String
) {
}