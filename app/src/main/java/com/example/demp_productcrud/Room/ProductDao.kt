package com.example.demp_productcrud.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.demp_productcrud.Models.Product

@Dao
interface ProductDao {
    @Insert
    suspend fun insertProduct(product: Product)

    @Insert
    suspend fun insertProductList(products: List<Product>)

    @Update
    suspend  fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM Product")
    fun getProduct(): LiveData<List<Product>>
}