//package com.example.myproducts
//
//import ProductRVAdapter
//import ProductViewModel
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.GridLayoutManager
//import com.example.myproducts.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var productRVAdapter: ProductRVAdapter
//    private val viewModel by viewModels<ProductViewModel>()
//    private var productList: List<Product> = emptyList()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        initializeList()
//        viewModel.fetchProducts()
//
//
//    }
//
//   private fun initializeList() {
//        viewModel.productList.observe(this) {
//            productRVAdapter = ProductRVAdapter(productList?: emptyList(),this)
//            binding.rvProducts.layoutManager = GridLayoutManager(this@MainActivity, 2)
//            binding.rvProducts.adapter = productRVAdapter
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        initializeList()
//    }
//}
//
//
//
//
//


package com.example.myproducts

import ProductRVAdapter
import ProductViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myproducts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var productRVAdapter: ProductRVAdapter
    private val viewModel by viewModels<ProductViewModel>()
    private var productList: List<Product> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Call the function to initialize the RecyclerView
        initializeList()

        viewModel.fetchProducts()
    }

    private fun initializeList() {
        viewModel.productList.observe(this) { products ->
            products?.let {
                productList = it
                productRVAdapter = ProductRVAdapter(productList, this)
                binding.rvProducts.layoutManager = GridLayoutManager(this@MainActivity, 2)
                binding.rvProducts.adapter = productRVAdapter

                productRVAdapter.notifyDataSetChanged()
            }
        }
    }
}
