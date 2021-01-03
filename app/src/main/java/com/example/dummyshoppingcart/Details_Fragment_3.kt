package com.example.dummyshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class Details_Fragment_3 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details__3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       lateinit var product:Product
        //val id = arguments?.getInt("ID")
        //product = products.find{id==it.id}

        arguments?.let{
            val args = Details_Fragment_3Args.fromBundle(it)
            product = products.find{args.id == it.id}!!

        }

        val prolongdesc = view.findViewById<TextView>(R.id.prolongdesc)
        val proname = view.findViewById<TextView>(R.id.name)
        val proprice = view.findViewById<TextView>(R.id.price)
        val prodesc = view.findViewById<TextView>(R.id.description)
        val proimage = view.findViewById<ImageView>(R.id.proImage)


        product?.let{
            proname.text = it.name
            proprice.text = "Price - Rs "+it.Price.toString()
            prodesc.text = it.shortDescription
            prolongdesc.text = it.longDescription
            proimage.setImageResource(it.imageId)
        }

        val buttonBuy = view.findViewById<Button>(R.id.buttonBuy)
        buttonBuy.setOnClickListener{
           // var bundle = Bundle()
            //bundle.putString("price",product?.Price.toString())
            //bundle.putInt("img",product?.imageId!!)
            if(product?.id!=null)
            {findNavController().navigate(Details_Fragment_3Directions.actionDetailsToCheckout(product.id))}
        }
    }

}