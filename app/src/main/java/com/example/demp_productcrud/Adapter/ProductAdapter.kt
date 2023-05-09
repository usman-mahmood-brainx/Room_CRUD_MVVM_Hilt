package com.example.demp_productcrud.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demp_productcrud.CreateFormActivity
import com.example.demp_productcrud.Models.Product
import com.example.demp_productcrud.R
import com.example.demp_productcrud.viewModels.ProductViewModel

class ProductAdapter(private val context: Context, private val productList: List<Product>,private val viewModel: ProductViewModel) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_layout, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = productList[position]

        holder.tvName.text = product.name
        holder.tvPrice.text = product.price.toString()

        holder.btnEdit.setOnClickListener {
            val intent = Intent(context, CreateFormActivity::class.java)
            intent.putExtra("FormType","Update")
            intent.putExtra("id",product.id)
            intent.putExtra("name",product.name)
            intent.putExtra("price",product.price)
            context.startActivity(intent)
        }

        holder.btnDelete.setOnClickListener {
            Toast.makeText(context,"Item Delted item",Toast.LENGTH_SHORT).show()
            viewModel.deleteProduct(product)
            notifyDataSetChanged()
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return productList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ProductView: View) : RecyclerView.ViewHolder(ProductView) {
        val tvName: TextView = ProductView.findViewById(R.id.tvProductName)
        val tvPrice: TextView = ProductView.findViewById(R.id.tvProductPrice)
        val btnEdit: ImageButton = ProductView.findViewById(R.id.imgbtnEdit)
        val btnDelete: ImageButton = ProductView.findViewById(R.id.imgbtnDelete)



    }
}