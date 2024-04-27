package com.project.canary_sound_sphere_app.data.model

import com.google.gson.annotations.SerializedName

data class EventModelDetails(
    @SerializedName("id") val id: String,
    @SerializedName("logo") val logo: String,
    @SerializedName("image") val image: String,
    @SerializedName("name") val name: String,
    @SerializedName("date") val date: String,
    @SerializedName("time") val time: String,
    @SerializedName("capacity") val capacity: Int,
    @SerializedName("description") val description: String,
    @SerializedName("direction") val direction: String,
    @SerializedName("marker") val marker: String,
    @SerializedName("ticket_store") val ticket_store: String,
)
