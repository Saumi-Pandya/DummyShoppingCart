package com.example.dummyshoppingcart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
 val products = mutableListOf<Product>(Product(1,"Pixel 3A",39990F, R.drawable.pixel3a,"Meet Pixel 3A",
                           "Save your photos with free, unlimited storage with Google Photos."),Product(2,"Google Alexa",7000F,
                                 R.drawable.googlealexa, "Help is here. Meet Alexa", "Get entertained all day long and control your smart home with Alexa"),
                          Product(3,"Fitbit",1700F,R.drawable.fitbit,"Health conscious? Try this","Keep a track of the calories burnt without much effort")
                         ,Product(4,"Induction",7500F,R.drawable.induction,"Risk free and efficient","Get rid of heavy gas cylinders" +
                         "and monthly refilling, it's time to go electric"), Product(5,"Microwave",8700F,R.drawable.microwave,"Save your time",
                            "Instantly heats up your food. Also, don't forget to bake cakes with ease anyday, everyday"),Product(6,"Mixer Grinder",
                           4300F,R.drawable.microwave,"Grind anything, anytime","Get rid of time consuming, boring grinding process, use " +
                            "electric Mixer Grinder for enhanced performance and efficiency"))

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}