package com.example.example

import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlin(

    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("category") var category: String,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("created_at") var createdAt: String

)