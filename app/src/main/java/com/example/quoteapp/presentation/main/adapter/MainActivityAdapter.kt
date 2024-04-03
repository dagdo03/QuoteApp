package com.example.quoteapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quoteapp.core.ViewHolderBinder
import com.example.quoteapp.data.model.Quote
import com.example.quoteapp.databinding.LayoutQuoteBinding

class MainActivityAdapter() :
    RecyclerView.Adapter<MainActivityAdapter.QuoteItemViewHolder>() {
    private val dataDiffer =
        AsyncListDiffer(
            this,
            object : DiffUtil.ItemCallback<Quote>() {
                override fun areItemsTheSame(
                    oldItem: Quote,
                    newItem: Quote
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: Quote,
                    newItem: Quote
                ): Boolean {
                    return oldItem.hashCode() == newItem.hashCode()
                }
            }
        )

    class QuoteItemViewHolder(
        private val binding: LayoutQuoteBinding
    ) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Quote> {

        override fun bind(item: Quote) {
            item.let {
                binding.tvAnimeValue.text = it.anime
                binding.tvCharacterValue.text = it.character
                binding.tvQuoteValue.text = it.quote
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteItemViewHolder {
        val binding =
            LayoutQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteItemViewHolder(binding)
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun onBindViewHolder(holder: QuoteItemViewHolder, position: Int) {
        holder.bind(dataDiffer.currentList[position])
    }
}