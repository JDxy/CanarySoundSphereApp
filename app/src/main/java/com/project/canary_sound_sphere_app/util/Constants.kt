package com.project.canary_sound_sphere_app.util

class Constants {
    companion object{
        //Importante setear la ip y poner la del equipo sino PLUF!
        const val BASE_URL = "http://192.168.0.177:9006/"
        const val ENDPOINT_GET_ALL_EVENTS="events"
        const val ENDPOINT_EVENT_BY_ID="events/{id}"
        const val ENDPOINT_GET_ALL_AUTHORS="authors"
        const val ENDPOINT_GET_AUTHOR_BY_ID="authors/{id}"
        const val CUSTOM_BLACK=0xFF2B2626
    }
}