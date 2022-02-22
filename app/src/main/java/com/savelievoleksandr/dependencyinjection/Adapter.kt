package com.savelievoleksandr.dependencyinjection

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.savelievoleksandr.dependencyinjection.databinding.ItemBinding
import com.savelievoleksandr.dependencyinjection.model.Item

class Adapter :
    ListAdapter<Item, Adapter.ItemViewHolder>
        (object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item)
                : Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var itemBinding: ItemBinding? = null
        fun bind(item: Item) {
            with(itemBinding!!) {
                Glide.with(icon.context)
                    .load(item.thumbnailUrl)
                    .centerInside()
                    .error(R.drawable.ic_launcher_background)
                    .into(icon)
                itemTitle.text = item.title
                icon.visibility = ImageView.VISIBLE
            }
        }

        init {
            itemBinding = binding
        }
    }
}