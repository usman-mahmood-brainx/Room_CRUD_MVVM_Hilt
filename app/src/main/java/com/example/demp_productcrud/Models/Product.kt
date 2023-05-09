package com.example.demp_productcrud.Models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val price:Int,
)
