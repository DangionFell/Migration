package com.example.migration.presentation.methodinfoscreen.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.MigrationMethodInfo
import com.example.domain.models.Text
import com.example.migration.databinding.TextItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class TextDelegate : AbsListItemAdapterDelegate <Text, MigrationMethodInfo, TextDelegate.TextViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): TextViewHolder {
        val binding = TextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun isForViewType(item: MigrationMethodInfo, items: MutableList<MigrationMethodInfo>, position: Int): Boolean {
        return item is Text
    }

    override fun onBindViewHolder(item: Text, viewHolder: TextViewHolder, payloads: MutableList<Any>) {
        viewHolder.binding.textView.text = item.text
    }

    class TextViewHolder(val binding: TextItemBinding) : RecyclerView.ViewHolder(binding.root)
}