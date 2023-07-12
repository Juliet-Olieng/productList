package com.example.myproducts

data class ProductResponse(
    var products:List<Product>,
    var total:Int,
    var skip:Int,
    var payment:Int
)
