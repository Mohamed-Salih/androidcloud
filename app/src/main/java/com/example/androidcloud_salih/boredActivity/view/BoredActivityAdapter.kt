package com.example.androidcloud_salih.boredActivity.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidcloud_salih.boredActivity.model.BoredActivityUi
import com.example.androidcloud_salih.databinding.ItemBoredActivityBinding

val diffUtils = object : DiffUtil.ItemCallback<BoredActivityUi>() {
    override fun areItemsTheSame(oldItem: BoredActivityUi, newItem: BoredActivityUi): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BoredActivityUi, newItem: BoredActivityUi): Boolean {
        return oldItem == newItem
    }

}

class BoredActivityAdapter : ListAdapter<BoredActivityUi, BoredActivityViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoredActivityViewHolder {
        return BoredActivityViewHolder(
            ItemBoredActivityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BoredActivityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class BoredActivityViewHolder(
    val binding: ItemBoredActivityBinding
) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var ui: BoredActivityUi

    fun bind(boredActivityUi: BoredActivityUi) {
        ui = boredActivityUi
        Glide.with(itemView.context)
            .load("https://www.pngall.com/wp-content/uploads/5/Red-Ball-Transparent.png")
            .into(binding.itemBoredActivityIcon)
        binding.itemBoredActivity.text = boredActivityUi.activity
        binding.itemBoredActivity1.text = boredActivityUi.type
        binding.itemBoredActivity2.text = boredActivityUi.participants.toString()
        binding.itemBoredActivity3.text = boredActivityUi.price.toString()
        binding.itemBoredActivity4.text = boredActivityUi.link
        binding.itemBoredActivity5.text = boredActivityUi.key
        binding.itemBoredActivity6.text = boredActivityUi.accessibility


    }
}