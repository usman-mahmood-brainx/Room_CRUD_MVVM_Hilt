package com.example.demp_productcrud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demp_productcrud.Adapter.ProductAdapter
import com.example.demp_productcrud.Models.Product
import com.example.demp_productcrud.databinding.ActivityMainBinding
import com.example.demp_productcrud.viewModels.ProductViewModel

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var productViewModel: ProductViewModel
    lateinit var productList: MutableList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        productList = mutableListOf()

        val productAdapter = ProductAdapter(this,productList,productViewModel)
        binding.rvProductList.layoutManager = LinearLayoutManager(this)
        binding.rvProductList.adapter = productAdapter

        productViewModel.products.observe(this, Observer{liveProductsList->
            productList.clear()
            productList.addAll(liveProductsList.reversed())
            productAdapter.notifyDataSetChanged()
        })


        binding.btnCreate.setOnClickListener {
            val intent = Intent(this@MainActivity,CreateFormActivity::class.java)
            intent.putExtra("FormType","Add" )
            startActivity(intent)
        }
    }
}