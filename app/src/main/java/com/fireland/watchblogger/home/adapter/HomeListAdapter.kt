package com.fireland.watchblogger.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fireland.watchblogger.databinding.WatchArticleItemBinding
import com.fireland.watchblogger.models.Article

class HomeListAdapter() :
    ListAdapter<Article, HomeListViewHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.title == newItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = WatchArticleItemBinding.inflate(inflater, parent, false)
        return HomeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        val currentArticle = getItem(position)
        holder.bind(currentArticle)
    }
}

class HomeListViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Article) {
        val itemBinding = binding as WatchArticleItemBinding
        itemBinding.article = article
        itemBinding.executePendingBindings()
    }
}