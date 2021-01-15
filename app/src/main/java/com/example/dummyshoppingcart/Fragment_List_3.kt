package com.example.dummyshoppingcart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment : Fragment(), ProductAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment__list_3, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //findViewById can be replaced with the widget id directly
        val productList = view.findViewById<RecyclerView>(R.id.productRecycle).apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = ProductAdapter(products,this@ListFragment)
            setHasFixedSize(true)


        }
        val layoutManager=LinearLayoutManager(activity)

        DividerItemDecoration(requireContext(),layoutManager.orientation).apply {
            productList.addItemDecoration(this)
        }
    }

    override fun onItemClick(position: Int) {
      // val bundle: Bundle = Bundle()
        //bundle.putInt("ID",products[position].id)
        findNavController().navigate(ListFragmentDirections.actionFragmentList3ToDetailsFragment3(products[position].id))
        //Toast.makeText(activity,"Product ${products[position].name} has been clicked",Toast.LENGTH_SHORT).show()
    }
}
