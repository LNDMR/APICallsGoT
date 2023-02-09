package com.example.apicalls.data.remote

import com.example.apicalls.data.model.GoTCharacter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val BASE_URL = "https://thronesapi.com/api/v2/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface GoTApiService {
    @GET("Characters")
    suspend fun getCharacters(): List<GoTCharacter>
}

object GoTApi {
    val retrofitService: GoTApiService by lazy { retrofit.create(GoTApiService::class.java) }

}