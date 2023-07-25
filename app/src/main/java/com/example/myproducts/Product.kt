package com.example.myproducts

import com.google.gson.annotations.SerializedName

data class Product(
    val id:Int,
    val title:String,
    @SerializedName("description") val desc:String,
    val price:Double,
    val rating:Double,
    val stock:Int,
    val brand:String,
    val category: String,
    val thumbnail:String
)
