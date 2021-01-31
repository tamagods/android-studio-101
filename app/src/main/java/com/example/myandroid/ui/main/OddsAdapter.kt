package com.example.myandroid.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myandroid.databinding.LayoutRecyclerViewItemBinding

class OddsAdapter(
    private val oddses: ArrayList<OddsModel> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LayoutRecyclerViewItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return OddsViewHolder(binding);
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is OddsViewHolder -> {
                holder.bind(oddses[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return oddses.count()
    }

    fun update(list: List<OddsModel>) {
        oddses.clear()
        oddses.addAll(list);
        notifyDataSetChanged();
    }

    class OddsViewHolder(
        val binding: LayoutRecyclerViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: OddsModel) {
            binding.ivLogo.setImageResource(model.image)
            binding.tvName.text = model.name
        }
    }
}