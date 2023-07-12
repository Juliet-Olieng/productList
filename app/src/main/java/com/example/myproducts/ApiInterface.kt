package com.example.myproducts

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET(("/product"))
    fun getProduct():Call<ProductResponse>
    @GET("/product/{id}")
    fun getProductById(@Path("id")productId:Int): Call<Product>
    @POST("/product/")
    fun postProducer(@Body product:Product):Call<Product>
}