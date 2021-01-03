package com.example.dummyshoppingcart

import androidx.lifecycle.ViewModel

class CheckoutViewModel(id:Int,initialqty:Int): ViewModel() {
    val product = products.find{it.id==id}
    private var _qty = initialqty

    val qty:Int
       get() = _qty

    fun addqty(q:Int){
        _qty+=q
    }

    fun reduceqty(q:Int){
        if(_qty-q>0){
        _qty-=q}
    }
}