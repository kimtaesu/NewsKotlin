package com.hucet.newskotlin.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hucet.newskotlin.R
import com.hucet.newskotlin.model.NewsSuperModel
import com.hucet.todo.model.RedditNewsItem
import kotlinx.android.synthetic.main.list_item_news.view.*

class NewsViewHolderLoading : ViewTypeDelegateAdapter {


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: NewsSuperModel) {
    }

    class NewsViewHolder : RecyclerView.ViewHolder {
        constructor(parent: ViewGroup) :
                super(LayoutInflater.from(parent.context).inflate(R.layout.list_item_news, parent, false)) {

        }

        fun bind(item: RedditNewsItem) = with(itemView) {
//            Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
//            img_thumbnailloadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
//            time.text = item.created.getFriendlyTime()
        }
    }

}