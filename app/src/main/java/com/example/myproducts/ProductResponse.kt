package com.example.myproducts

data class ProductResponse(
    var products:List<Product>,
    var total:Int,
    var skip:Int,
    var limit:Int
)
//{
//    "products": [
//    {
//        "id": 1,
//        "title": "iPhone 9",
//        "description": "An apple mobile which is nothing like apple",
//        "price": 549,
//        "discountPercentage": 12.96,
//        "rating": 4.69,
//        "stock": 94,
//        "brand": "Apple",
//        "category": "smartphones",
//        "thumbnail": "...",
//        "images": ["...", "...", "..."]
//    },
//    {...},
//    {...},
//    {...}
//    // 30 items
//    ],
//
//    "total": 100,
//    "skip": 0,
//    "limit": 30
//}
