package com.example.myproducts

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myproducts.databinding.ProductBinding

class ProductDescription:AppCompatActivity() {
    lateinit var binding: ProductBinding
    var productId=-1
    var productTitle=""
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ProductBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var bundle=intent.extras
        if (bundle != null) {
            productId = bundle.getInt("PRODUCT_ID", -1)
        }
        if (bundle!=null)
            productTitle=bundle.getString("PRODUCT_TITLE","")

            binding.tvProductId.text="$productId"
            binding.tvProductTitle.text="$productTitle"
        }
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "$productTitle", Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"$productId",Toast.LENGTH_SHORT).show()
    }


    }



