package com.migration.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.migration.R
import com.example.migration.databinding.MainCardItemBinding

class CountryAdapter(private val listener : Listener): RecyclerView.Adapter<CountryAdapter.CountryHolder>() {

    private val countryList = mutableListOf<com.migration.domain.models.Country>()

    class CountryHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = MainCardItemBinding.bind(item)
        fun bind(country: com.migration.domain.models.Country, context: Context, listener: Listener) = with(binding){
            nameText.text = country.name
            methodsText.text = country.migration_methods
            Glide.with(context).load(country.backUrl).into(backgroundImage)
            Glide.with(context).load(country.flagUrl).into(flagImage)

            itemView.setOnClickListener{
                listener.onClick(country)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_card_item, parent, false)
        return CountryHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryHolder, position: Int) {
        holder.bind(countryList[position], holder.itemView.context, listener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addCountryList(list : List<com.migration.domain.models.Country>){
        countryList.addAll(list)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(country: com.migration.domain.models.Country)
    }
}