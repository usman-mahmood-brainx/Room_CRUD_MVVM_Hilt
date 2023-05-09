package com.example.demp_productcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.demp_productcrud.Models.Product
import com.example.demp_productcrud.databinding.ActivityCreateFormBinding
import com.example.demp_productcrud.viewModels.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CreateFormActivity : AppCompatActivity() {
    lateinit var binding: ActivityCreateFormBinding
    lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val formType =  intent.getStringExtra("FormType",)
        val id = intent.getIntExtra("id",0)

        viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        
        if(formType == "Add")
            binding.tvFormLabel.text = "Add Product"
        else{
            binding.tvFormLabel.text = "Update Product"
            val name = intent.getStringExtra("name")
            binding.etName.setText(name)
            binding.etPrice.setText(intent.getIntExtra("price",0).toString())
            binding.btnSave.text = "Update"
        }

        binding.btnSave.setOnClickListener {


            val name  = binding.etName.text.toString().trim()
            val price  = binding.etPrice.text.toString().trim().toInt()
            val product = Product(id,name,price)

            if(formType == "Add"){
               viewModel.addProduct(product)
            }
            else{
                viewModel.editProduct(product)
            }

            finish()

        }

    }

  
}