package com.example.dodopizza

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodopizza.databinding.PizzaItemBinding

class PizzaAdapter(private var pizzaList: ArrayList<Pizza>, private val onPizzaClick: (Pizza) -> Unit):RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {
    inner class PizzaViewHolder(val binding: PizzaItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pizza: Pizza){
            with(binding){
                pizzaImage.setImageResource(pizza.pizza_image)
                pizzaName.text =  pizza.name
                pizzaDescription.text = pizza.description
                pizzaPrice.text = pizza.price

                root.setOnClickListener{
                    onPizzaClick(pizza)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(PizzaItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun setFilteredList(pizzaList: ArrayList<Pizza>){
        this.pizzaList = pizzaList
        notifyDataSetChanged()
    }

    fun setData(pizza: ArrayList<Pizza>){
        pizzaList.clear()
        pizzaList.addAll(pizza)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pizzaList.size
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(pizzaList[position])



    }
}