package com.example.myproducts

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.POST

object ApiClient {
    var retrofit=Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun<T>buildClient(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
    interface ApiInterface{

    }


}