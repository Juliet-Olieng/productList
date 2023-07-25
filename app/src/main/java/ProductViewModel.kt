import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproducts.ApiClient
import com.example.myproducts.ApiInterface
import com.example.myproducts.Product
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    private var _productList: MutableLiveData<List<Product>> = MutableLiveData()
    val productList: LiveData<List<Product>> = _productList


    fun fetchProducts() {
        viewModelScope.launch {
            val response = apiClient.getProducts()
            if (response.isSuccessful) {
                val products = response.body()?.products ?: emptyList()

                _productList.value = products

            }

        }

    }
}




