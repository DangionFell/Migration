package com.example.migration.presentation.methodinfoscreen.delegates

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.BulletList
import com.example.domain.models.MigrationMethodInfo
import com.example.migration.R
import com.example.migration.databinding.BulletlistItemBinding
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate

class BulletListDelegate : AbsListItemAdapterDelegate<BulletList, MigrationMethodInfo, BulletListDelegate.BulletListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): BulletListViewHolder {
        val binding = BulletlistItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BulletListViewHolder(binding)
    }

    override fun isForViewType(item: MigrationMethodInfo, items: MutableList<MigrationMethodInfo>, position: Int): Boolean {
        return item is BulletList
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(item: BulletList, viewHolder: BulletListViewHolder, payloads: MutableList<Any>) {
        with(viewHolder.binding){
            item.list.forEach {
                val textView = TextView(viewHolder.itemView.context).apply {
                    text = "• $it"
                    textSize = 16f
                    setTextColor(Color.BLACK)
                    typeface = ResourcesCompat.getFont(context, R.font.franklin_gothic_medium_regular)
                }

                liner.addView(textView)
            }
        }
    }

    class BulletListViewHolder(val binding: BulletlistItemBinding) : RecyclerView.ViewHolder(binding.root)
}