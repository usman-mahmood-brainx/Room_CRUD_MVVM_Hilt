package com.example.demp_productcrud.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demp_productcrud.Models.Product
import com.example.demp_productcrud.Repository.ProductRepository


import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getProducts()
        }
    }

    val products:LiveData<List<Product>>
        get() = repository.products
 
    fun addProductList(products: List<Product>){
        viewModelScope.launch {
            repository.addProductList(products)
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            repository.addProducts(product)
        }
    }

     fun editProduct(product: Product) {
        viewModelScope.launch {
            repository.updateProducts(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            repository.deleteProduct(product)
        }
    }

}