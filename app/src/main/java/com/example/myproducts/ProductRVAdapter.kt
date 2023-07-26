package com.example.myproducts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproducts.databinding.ProducListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductRVAdapter(private var productList: List<Product>, private val context: Context) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProducListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentProduct = productList[position]
        val binding = holder.binding

        binding.tvName.text = currentProduct.title
        binding.tvPrice.text = currentProduct.price.toString()
        binding.tvRatings.text = currentProduct.rating.toString()
        binding.tvDescription.text = currentProduct.desc

        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .resize(80, 80)
            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.ivContact)

        binding.ivContact.setOnClickListener {
            val intent = Intent(context, ProductDescription::class.java)
            intent.putExtra("PRODUCT_ID", currentProduct.id)
            intent.putExtra("PRODUCT_TITLE", currentProduct.title)
            context.startActivity(intent)

        }
    }
}

class ProductViewHolder(var binding: ProducListBinding) : RecyclerView.ViewHolder(binding.root) {}
