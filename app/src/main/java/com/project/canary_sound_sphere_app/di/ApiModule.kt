package com.project.canary_sound_sphere_app.di

import com.project.canary_sound_sphere_app.data.CanarySoundSphereClient
import com.project.canary_sound_sphere_app.util.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Aqui añádimos las dependencias
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    //Se añade retrofit
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //Función para proveer a la Api
    @Singleton
    @Provides
    fun providesApi(retrofit: Retrofit): CanarySoundSphereClient {
        return  retrofit.create(CanarySoundSphereClient::class.java)
    }
}