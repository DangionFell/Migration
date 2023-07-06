package com.example.migration.presentation.methodinfoscreen.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.MigrationMethodInfo
import com.example.domain.models.Title
import com.example.migration.databinding.TitleItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class TitleDelegate : AbsListItemAdapterDelegate<Title, MigrationMethodInfo, TitleDelegate.TitleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): TitleViewHolder {
        val binding = TitleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleViewHolder(binding)
    }

    override fun isForViewType(item: MigrationMethodInfo, items: MutableList<MigrationMethodInfo>, position: Int): Boolean {
        return item is Title
    }

    override fun onBindViewHolder(item: Title, viewHolder: TitleViewHolder, payloads: MutableList<Any>) {
        viewHolder.binding.textView.text = item.text
    }

    class TitleViewHolder(val binding: TitleItemBinding) : RecyclerView.ViewHolder(binding.root)
}