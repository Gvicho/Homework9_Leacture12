package com.example.recycler2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler2.databinding.Item1Binding

class ListAdapter1(private val data: MutableList<Product>):RecyclerView.Adapter<ListAdapter1.ListViewHolder>(){

    inner class ListViewHolder(private val binding: Item1Binding):RecyclerView.ViewHolder(binding.root){
        fun bind(product:Product) {
            when(product.outfitType ){
                OutfitType.PARTY -> binding.imgView.setImageResource(R.drawable.bitmap)
                OutfitType.BEACH -> binding.imgView.setImageResource(R.drawable.bitmap1)
                OutfitType.RENDOM-> binding.imgView.setImageResource(R.drawable.bitmap2)
                else -> binding.imgView.setImageResource(R.drawable.bitmap3)
            }
            binding.tvName.text = product.outfitName
            binding.tvPrise.text = "$" + product.priseOfOutfit.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(Item1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(data[position])
    }
}