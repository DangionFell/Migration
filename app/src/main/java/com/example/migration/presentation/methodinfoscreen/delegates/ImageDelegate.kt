package com.example.migration.presentation.methodinfoscreen.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.Image
import com.example.domain.models.MigrationMethodInfo
import com.example.migration.databinding.ImageItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class ImageDelegate : AbsListItemAdapterDelegate<Image, MigrationMethodInfo, ImageDelegate.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): ImageViewHolder {
        val binding = ImageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun isForViewType(item: MigrationMethodInfo, items: MutableList<MigrationMethodInfo>, position: Int): Boolean {
        return item is Image
    }

    override fun onBindViewHolder(item: Image, viewHolder: ImageViewHolder, payloads: MutableList<Any>) {
        viewHolder.binding.text.text = item.text

        Glide.with(viewHolder.itemView.context)
            .load(item.imagePath)
            .into(viewHolder.binding.backgroundImage)
    }

    class ImageViewHolder(val binding: ImageItemBinding) : RecyclerView.ViewHolder(binding.root)
}