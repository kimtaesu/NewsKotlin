package com.hucet.newskotlin.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hucet.newskotlin.model.NewsSuperModel

object AdapterConstants {
    const val ITEM = 1
    const val LOADING = 2
}

interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: NewsSuperModel)
}