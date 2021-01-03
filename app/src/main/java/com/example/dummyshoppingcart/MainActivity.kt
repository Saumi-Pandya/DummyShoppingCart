package com.example.dummyshoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 val products = mutableListOf<Product>(Product(1,"Pixel 3A",65000F, R.drawable.ic_launcher_foreground,"It is a good product",
                           "Please do buy this. It's great"),Product(2,"Google Alexa",35000F, R.drawable.ic_launcher_background,
                                "It is a good speaker", "You can instruct it"))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val fragmanager = supportFragmentManager.beginTransaction()
        //fragmanager.add(R)
    }
}