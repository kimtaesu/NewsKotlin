package com.hucet.todo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hucet.newskotlin.MyApplication
import com.hucet.newskotlin.R
import com.hucet.newskotlin.api.NewsManager
import com.hucet.newskotlin.api.request.NewsRequest
import com.hucet.newskotlin.module.NetworkModule
import com.hucet.newskotlin.module.NewsModule
import com.hucet.newskotlin.module.component.AppComponent
import com.hucet.newskotlin.module.component.NewsComponent
import javax.inject.Inject

class NewsFragment : Fragment() {

    @Inject
    lateinit var newsManager: NewsManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyApplication.getNewsComponent(NewsRequest()).inject(this)
        requestNews()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


    private fun requestNews() {
        newsManager.getNews()
                .subscribe({
                    Log.e("!!!!!!!!!!", "aaaaaaaa")
                }, {
                    Log.e("!!!!!!!!!!!!!", "bbbbbbbbbbbbbbb")
                })
    }
}

