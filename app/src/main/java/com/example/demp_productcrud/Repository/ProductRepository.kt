package com.example.demp_productcrud.Repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demp_productcrud.Models.Product
import com.example.demp_productcrud.Room.ProductDatabase
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDatabase: ProductDatabase,
) {


    private lateinit var productsLiveData: LiveData<List<Product>>

    val products: LiveData<List<Product>>
        get() = productsLiveData

    fun getProducts(){
        productsLiveData = productDatabase.getProductDao().getProduct()
    }

    suspend fun addProducts(product: Product) {
        productDatabase.getProductDao().insertProduct(product)
    }
    suspend fun addProductList(products: List<Product>) {
        productDatabase.getProductDao().insertProductList(products)
    }

    suspend fun updateProducts(product: Product) {
        productDatabase.getProductDao().updateProduct(product)
    }

    suspend fun deleteProduct(product: Product) {
        productDatabase.getProductDao().deleteProduct(product)
    }
}