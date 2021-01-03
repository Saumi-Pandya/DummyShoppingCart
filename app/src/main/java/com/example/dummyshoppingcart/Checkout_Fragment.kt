package com.example.dummyshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController


class Checkout_Fragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout_, container, false)
    }
       var qty = 1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = Checkout_FragmentArgs.fromBundle(requireArguments()).id
        val viewModelFactory = CheckoutViewModelFactory(id,1)
       lateinit var  viewModel : CheckoutViewModel
        viewModel = ViewModelProvider(this,viewModelFactory).get(CheckoutViewModel::class.java)

        //setData(viewModel.product)

        lateinit var product: Product
       /*  arguments?.let{
             val args = Checkout_FragmentArgs.fromBundle(it)
             product = products.find{args.id==it.id}!!

         }*/

        product = viewModel.product!!

        var price = product.Price.toInt()
        var pricetemp = price
        val imid = product.imageId

        val quantity = view.findViewById<TextView>(R.id.qty)
        val image = view.findViewById<ImageView>(R.id.image)
        val pricefc = view.findViewById<TextView>(R.id.pricefc)
        val total = view.findViewById<TextView>(R.id.total)
        image.setImageResource(imid)
        pricefc.text = "Price - Rs " + product.Price.toString()
        total.text = "Order Total - Rs " + (product.Price*viewModel.qty)
        quantity.text = "Qty - " + viewModel.qty.toString()

        val chbutton = view.findViewById<Button>(R.id.checkbutton)
        val add_quantity = view.findViewById<Button>(R.id.add_quantity)
        val reduce_quantity = view.findViewById<Button>(R.id.reduce_quantity)

        add_quantity.setOnClickListener{
            viewModel.addqty(1)
            quantity.text = "Qty - " + viewModel.qty.toString()
            pricetemp = price*viewModel.qty
            total.text = "Price - Rs " + pricetemp.toString()
        }

        reduce_quantity.setOnClickListener{
            viewModel.reduceqty(1)
            quantity.text = "Qty - " + viewModel.qty.toString()
            pricetemp = price*viewModel.qty
            total.text = "Price - Rs " + pricetemp.toString()
            }


        chbutton.setOnClickListener{
            findNavController().navigate(R.id.action_check_to_thanks)
        }
    }


}