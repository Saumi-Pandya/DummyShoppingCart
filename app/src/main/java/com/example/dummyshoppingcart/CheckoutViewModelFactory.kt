package com.example.dummyshoppingcart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CheckoutViewModelFactory(private val id:Int,private val quantity:Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CheckoutViewModel::class.java)){
            @Suppress("Unchecked Cast")
            return CheckoutViewModel(id,quantity) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}