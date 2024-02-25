package com.example.dodopizza

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dodopizza.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: PizzaAdapter
    private lateinit var newPizzaList: ArrayList<Pizza>
    private lateinit var binding: ActivityMainBinding
    private lateinit var searchView: SearchView
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.pizzaList.setHasFixedSize(true)

        newPizzaList = arrayListOf<Pizza>()
        searchView = findViewById(R.id.search_view)
        submitButton = findViewById(R.id.submitButton)
        newPizzaList.add(
            Pizza(
                R.drawable.kebab,
                "Вау! Кебаб",
                "Мясо говядины, соус ранч, сыр моцарелла, сладкий перец, томаты, красный лук и фирменный томатный соус",
                "2800",
                "30, традиционное тесто 30, 530 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.naruto,
                "Наруто Пицца",
                "Куриные кусочки, соус терияки, ананасы, моцарелла, фирменный соус альфредо",
                "3800",
                "30, традиционное тесто 30, 570 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.bayern,
                "Баварская",
                "Острые колбаски чоризо, маринованные огурчики, красный лук, томаты, горчичный соус, моцарелла, фирменный томатный соус",
                "2600",
                "30, традиционное тесто 30, 550 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.heart,
                "Пепперони-сердце",
                "Уникальная пицца в форме сердца. Томатный соус, пепперони, моцарелла",
                "3400",
                "30, тонкое тесто 30, 380 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.grib,
                "Пепперони с грибами",
                "Пикантная пепперони, моцарелла, шампиньоны, соус альфредо",
                "1900",
                "30, традиционное тесто 30, 510 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.haram,
                "Ветчина и огурчики",
                "Соус ранч, моцарелла, ветчина из цыпленка, маринованные огурчики, красный лук",
                "1900",
                "30, традиционное тесто 30, 500 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.smeshariki,
                "Миксик",
                "Пицца четвертинками с ветчиной из цыпленка, томатами, брынзой, моцареллой, фирменным соусом альфредо. Набор юного садовода в подарок",
                "2200",
                "25, традиционное тесто 25, 370 г"
            )
        )
        newPizzaList.add(
            Pizza(
                R.drawable.mega_grib,
                "Пицца Жюльен",
                "Цыпленок, шампиньоны, ароматный грибной соус, лук, сухой чеснок, моцарелла, смесь сыров чеддер и пармезан, фирменный соус альфредо",
                "2600",
                "30, традиционное тесто 30, 640 г"
            )
        )

        adapter = PizzaAdapter(newPizzaList, onPizzaClick = {
            handPizzaClick(it)
        })
        binding.pizzaList.adapter = adapter
        binding.pizzaList.layoutManager = LinearLayoutManager(this)

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(newText: String?): Boolean {
                filterList(newText)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        submitButton.setOnClickListener {
            val query = searchView.query.toString()
            filterList(query)
        }

    }
    private fun filterList(query: String?){
        if(query!=null){
            val filteredList = ArrayList<Pizza>()

            for(i in newPizzaList){
                if(i.name!!.lowercase(Locale.ROOT).contains(query.lowercase())){
                    filteredList.add(i)
                }
            }

            adapter.setFilteredList(filteredList)
        }
    }


    private fun handPizzaClick(pizza: Pizza){
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra("image", pizza.pizza_image)
        intent.putExtra("name", pizza.name)
        intent.putExtra("description", pizza.description)
        intent.putExtra("price", pizza.price)
        intent.putExtra("subDescription", pizza.subDescription)
        startActivity(intent)
    }


}