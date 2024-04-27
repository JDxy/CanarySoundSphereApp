package com.project.canary_sound_sphere_app.data.model

import com.google.gson.annotations.SerializedName

data class ResultApi(
    @SerializedName("results") val events: List<EventModel>
)

data class EventModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)