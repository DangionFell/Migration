package com.example.migration.presentation.methodinfoscreen.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.MigrationMethodInfo
import com.example.migration.databinding.BannerItemBinding
import com.example.migration.presentation.methodinfoscreen.models.Banner
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BannerDelegate(private val listener : Listener) : AbsListItemAdapterDelegate<Banner, MigrationMethodInfo, BannerDelegate.BannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): BannerViewHolder {
        val binding = BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BannerViewHolder(binding)
    }

    override fun isForViewType(item: MigrationMethodInfo, items: MutableList<MigrationMethodInfo>, position: Int): Boolean {
        return item is Banner
    }

    override fun onBindViewHolder(item: Banner, viewHolder: BannerViewHolder, payloads: MutableList<Any>) {
        viewHolder.binding.textView.text = item.text

        viewHolder.binding.root.setOnClickListener {
            listener.onClick()
        }
    }

    class BannerViewHolder(val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface Listener {
        fun onClick()
    }
}