package com.example.migration.presentation.country_screen.delagates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.SecondScreenItem
import com.example.domain.models.CountryHat
import com.example.migration.databinding.HatCardItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HatDelegate : AbsListItemAdapterDelegate <CountryHat, SecondScreenItem, HatDelegate.HatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): HatViewHolder {
        val binding = HatCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HatViewHolder(binding)
    }

    override fun isForViewType(item: SecondScreenItem, items: MutableList<SecondScreenItem>, position: Int): Boolean {
        return item is CountryHat
    }

    override fun onBindViewHolder(item: CountryHat, viewHolder: HatViewHolder, payloads: MutableList<Any>) {
        viewHolder.binding.name.text = item.name
        Glide.with(viewHolder.itemView.context)
            .load(item.backUrl)
            .into(viewHolder.binding.backgroundImage)
        Glide.with(viewHolder.itemView.context)
            .load(item.flagUrl)
            .into(viewHolder.binding.flagImage)
    }

    class HatViewHolder(val binding: HatCardItemBinding) : RecyclerView.ViewHolder(binding.root)
}
