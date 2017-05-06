package com.hucet.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hucet.newskotlin.MyApplication
import com.hucet.newskotlin.R
import com.hucet.newskotlin.api.NewsManager
import com.hucet.newskotlin.api.request.NewsRequest
import com.hucet.newskotlin.module.data.component.NetworkModule
import com.hucet.newskotlin.module.data.component.NewsModule
import com.hucet.newskotlin.module.data.component.AppComponent
import com.hucet.newskotlin.module.data.component.NewsComponent
import com.hucet.newskotlin.view.NewsAdapter
import com.hucet.newskotlin.view.viewholder.*
import com.hucet.todo.model.RedditNewsItem
import kotlinx.android.synthetic.main.fragment_content.*
import javax.inject.Inject

class NewsFragment : Fragment() {
    var dataset: List<RedditNewsItem> = ArrayList<RedditNewsItem>()
    val delegateAdapters: SparseArrayCompat<ViewTypeDelegateAdapter> = SparseArrayCompat()

    @Inject
    lateinit var newsManager: NewsManager;
    lateinit var newsComponent: NewsComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsComponent = MyApplication.getNewsComponent(NewsRequest())
        newsComponent.inject(this)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun init() {
        delegateAdapters.apply {
            put(AdapterConstants.ITEM, NewsViewHolderItem())
            put(AdapterConstants.LOADING, NewsViewHolderLoading())
        }

        news_list.apply {
            val linearLayout = LinearLayoutManager(context)
            layoutManager = linearLayout
            adapter = NewsAdapter(dataset, delegateAdapters)
        }
        requestNews()
    }

    private fun requestNews() {
        newsManager.getNews()
                .subscribe({
                    (news_list.adapter as NewsAdapter).addNewsItem(it)
                }, {
                    Toast.makeText(context, "Can't load reddit items", Toast.LENGTH_SHORT).show()

                })
    }
}

