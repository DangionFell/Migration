package com.example.migration.presentation.countryscreen.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.SecondScreenItem
import com.example.migration.presentation.countryscreen.models.CountryHeader
import com.example.migration.databinding.HeaderCardItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class HeaderDelegate : AbsListItemAdapterDelegate <CountryHeader, SecondScreenItem, HeaderDelegate.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): HeaderViewHolder {
        val binding = HeaderCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun isForViewType(item: SecondScreenItem, items: MutableList<SecondScreenItem>, position: Int): Boolean {
        return item is CountryHeader
    }

    override fun onBindViewHolder(item: CountryHeader, viewHolder: HeaderViewHolder, payloads: MutableList<Any>) {
        viewHolder.binding.name.text = item.name
        Glide.with(viewHolder.itemView.context)
            .load(item.backUrl)
            .into(viewHolder.binding.backgroundImage)
        Glide.with(viewHolder.itemView.context)
            .load(item.flagUrl)
            .into(viewHolder.binding.flagImage)
    }

    class HeaderViewHolder(val binding: HeaderCardItemBinding) : RecyclerView.ViewHolder(binding.root)
}
