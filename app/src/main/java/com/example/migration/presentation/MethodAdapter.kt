package com.example.migration.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.Method
import com.example.migration.R
import com.example.migration.databinding.MethodCardItemBinding

class MethodAdapter(private val listener : Listener): RecyclerView.Adapter<MethodAdapter.MethodHolder>() {

    private val methodList = mutableListOf<Method>()

    class MethodHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = MethodCardItemBinding.bind(item)
        fun bind(method: Method, listener: Listener) = with(binding){

            title.text = method.title
            text.text = method.text

            itemView.setOnClickListener{
                listener.onClick(method)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MethodHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.method_card_item, parent, false)
        return MethodHolder(view)
    }

    override fun getItemCount(): Int {
        return methodList.size
    }

    override fun onBindViewHolder(holder: MethodHolder, position: Int) {
        holder.bind(methodList[position], listener)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addMethodList(list : List<Method>){
        methodList.addAll(list)
        notifyDataSetChanged()
    }

    interface Listener{
        fun onClick(method: Method)
    }
}