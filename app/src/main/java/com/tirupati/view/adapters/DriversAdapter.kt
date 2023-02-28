package com.tirupati.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tirupati.databinding.ItemDriverBinding
import javax.inject.Inject

class DriversAdapter @Inject constructor(): RecyclerView.Adapter<DriversAdapter.DriversViewHolder>() {
    private val items: MutableList<String> = mutableListOf()

    inner class DriversViewHolder(private val binding: ItemDriverBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.driverName = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriversViewHolder {
        val binding = ItemDriverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DriversViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: DriversViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(newItems: List<String>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}