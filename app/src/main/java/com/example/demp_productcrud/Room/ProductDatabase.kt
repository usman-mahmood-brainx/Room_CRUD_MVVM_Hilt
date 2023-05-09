package com.example.demp_productcrud.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.demp_productcrud.Models.Product

@Database(entities = [Product::class,], version = 1, exportSchema = true)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao():ProductDao
}