package com.savelievoleksandr.dependencyinjection.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(
    @Json(name = "id") val id: Int,
    @Json(name = "title") val title: String,
    @Json(name = "thumbnailUrl") val thumbnailUrl: String,
)