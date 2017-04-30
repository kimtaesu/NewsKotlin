package com.hucet.newskotlin.view

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.hucet.newskotlin.api.response.NewsDataResponse
import com.hucet.newskotlin.view.viewholder.AdapterConstants
import com.hucet.newskotlin.view.viewholder.NewsViewHolderItem
import com.hucet.newskotlin.view.viewholder.NewsViewHolderLoading
import com.hucet.newskotlin.view.viewholder.ViewTypeDelegateAdapter
import com.hucet.todo.model.RedditNewsItem
import timber.log.Timber

class NewsAdapter(
        var dataset: List<RedditNewsItem>,
        val delegateAdapter: SparseArrayCompat<ViewTypeDelegateAdapter>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return delegateAdapter[viewType].onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapter.get(getItemViewType(position)).onBindViewHolder(holder, this.dataset[position])
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun getItemViewType(position: Int): Int {
        return dataset.get(position).getViewType()
    }

    fun addNewsItem(dataset: List<RedditNewsItem>) {
        this.dataset += dataset
        notifyDataSetChanged()
    }
}