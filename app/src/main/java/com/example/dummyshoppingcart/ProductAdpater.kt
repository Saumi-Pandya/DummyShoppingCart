package com.example.dummyshoppingcart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products:List<Product>, private val listener: OnItemClickListener):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    inner class ProductViewHolder(val iView: View):RecyclerView.ViewHolder(iView), View.OnClickListener{
        val proimage: ImageView = iView.findViewById(R.id.proImage)
        val proname: TextView = iView.findViewById(R.id.name)
        val proprice: TextView = iView.findViewById(R.id.price)
        val prodesc: TextView = iView.findViewById(R.id.description)

        init{
            iView.setOnClickListener(this)
        }


        override fun onClick(p0: View?) {
           val position = adapterPosition
            if(position!=RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ProductViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = products[position]
        with(holder){
            proname.text = item.name
            proprice.text = "Price - Rs "+item.Price.toString()
            prodesc.text = item.shortDescription
            proimage.setImageResource(item.imageId)

        }
    }
    interface OnItemClickListener{
        fun onItemClick(position:Int)
    }



}


