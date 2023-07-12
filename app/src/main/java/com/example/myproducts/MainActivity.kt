package com.example.myproducts

import ProductRVAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myproducts.databinding.ActivityMainBinding
import com.example.myproducts.databinding.ProducListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var productRVAdapter:ProductRVAdapter
    var productList:List<Product> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productRVAdapter=ProductRVAdapter(emptyList())
    }

    override fun onResume() {
        super.onResume()
        fetchProduct()
    }
    fun fetchProduct(){
        var apiClient=ApiClient.buildClient(ApiInterface::class.java)
        var request =apiClient.getProduct()//defined in the interface
        request.enqueue(object: Callback<ProductResponse> {
            override fun onResponse(call:Call<ProductResponse>,response:Response<ProductResponse>){
                if (response.isSuccessful){
                    var product =response.body()?.products
                    var productRVAdapter=ProductRVAdapter(product?: emptyList())
                    binding.rvProducts.layoutManager=GridLayoutManager(this@MainActivity,2)
                    binding.rvProducts.adapter=productRVAdapter
                    Toast.makeText(baseContext,
                    "fetched ${product?.size} product", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(baseContext,response.errorBody()?.string(),Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<ProductResponse>,t:Throwable){
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })

    }



}