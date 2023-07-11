package com.vitalyv.newsapp.service

import com.vitalyv.newsapp.model.NewsItemModel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface NewsApiService {

    @GET("market/v2/auto-complete") // Замените на URL вашего API
    suspend fun getNews(): Response {

        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://morning-star.p.rapidapi.com/market/v2/auto-complete?q=tesla")
            .get()
            .addHeader("X-RapidAPI-Key", "fc3ad550f2msh2c8d1cb48aa0ec8p181d36jsnbeeea56b98d7")
            .addHeader("X-RapidAPI-Host", "morning-star.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        return response
    }

    @GET("news/{id}") // Замените на URL вашего API
    suspend fun getNewsById(@Path("id") newsId: String): NewsItemModel



}