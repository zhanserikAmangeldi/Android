package com.example.dodopizza

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dodopizza.databinding.ActivityDetailedBinding
import com.example.dodopizza.databinding.ActivityMainBinding


class DetailedActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding

    companion object {
        const val key_image = "image"
        const val key_name = "name"
        const val key_description = "description"
        const val key_price = "price"
        const val key_subDescription = "subDescription"

    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val BigPictures = intent.getIntExtra("image", 0)
        binding.BigPicture.setImageResource(BigPictures)
        binding.PizzaNameBig.text = intent.getStringExtra("name")
        binding.pizzaDescriptionBig.text = intent.getStringExtra("description")
        binding.PizzaPrice.text = ("В корзину за " + intent.getStringExtra("price") + "T")
        binding.PizzaSubDesc.text = intent.getStringExtra(key_subDescription)


        val backButton = findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

}