package com.example.migration.presentation.country_screen.delagates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.SecondScreenItem
import com.example.domain.models.MigrationMethod
import com.example.migration.databinding.MethodCardItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class MigrationMethodDelegate(private val listener : Listener) : AbsListItemAdapterDelegate<MigrationMethod, SecondScreenItem, MigrationMethodDelegate.MigrationMethodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): MigrationMethodViewHolder {
        val binding = MethodCardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MigrationMethodViewHolder(binding)
    }

    override fun isForViewType(item: SecondScreenItem, items: MutableList<SecondScreenItem>, position: Int): Boolean {
        return item is MigrationMethod
    }

    override fun onBindViewHolder(item: MigrationMethod, viewHolder: MigrationMethodViewHolder, payloads: MutableList<Any>) {
        with(viewHolder.binding){
            title.text = item.title
            text.text = item.text
            root.setOnClickListener {
                listener.onClick(item)
            }
        }
    }

    class MigrationMethodViewHolder(val binding: MethodCardItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface Listener {
        fun onClick(method: MigrationMethod)
    }
}