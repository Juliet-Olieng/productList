import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproducts.Product
import com.example.myproducts.databinding.ProducListBinding
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProductRVAdapter(var productList: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var binding=ProducListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct=productList[position]
        var binding=holder.binding
        holder.binding.tvName.text=currentProduct.title
        holder.binding.tvPrice.text=currentProduct.price.toString()
        holder.binding.tvRatings.text=currentProduct.rating.toString()
        holder.binding.tvDescription.text=currentProduct.description
        Picasso
            .get()
            .load(currentProduct.thumbnail)
            .resize(80,80)
            .centerCrop()
            .transform(CropCircleTransformation())
            .into(binding.ivContact)
    }
}
class ProductViewHolder(var binding: ProducListBinding):RecyclerView.ViewHolder(binding.root){}