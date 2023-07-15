package com.vitalyv.newsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vitalyv.newsapp.databinding.ListItemsBinding
import com.vitalyv.newsapp.model.NewsItemModel


class NewsAdapter(private val context: Context,
                  private val dataset: List<NewsItemModel>,
                  val itemClickListener: (NewsItemModel) -> Unit):
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){

    class NewsViewHolder(val binding: ListItemsBinding) : RecyclerView.ViewHolder(binding.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ListItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = dataset[position]
/*        holder.binding.titleId.text = context.resources.getString(currentItem.titleView)
        holder.binding.contentTextViewId.text = context.resources.getString(currentItem.content)*/
        holder.binding.imageViewId.setImageResource(currentItem.image)

        holder.binding.root.setOnClickListener {
            itemClickListener(currentItem)
        }
    }


}