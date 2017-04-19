package com.hucet.newskotlin.api

import com.hucet.newskotlin.api.repository.NewsRepository
import com.hucet.newskotlin.api.response.NewsResponse
import com.hucet.newskotlin.module.service.GetNewsScope
import com.hucet.todo.extension.onDefaultThread
import com.hucet.todo.model.RedditNewsItem
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface NewsAPI {
    fun getNews(before: String, after: String, limit: String): Observable<Response<NewsResponse>>
}

class NewsApiImpl @Inject constructor(private val newsApi: NewsRepository) : NewsAPI {
    override fun getNews(before: String, after: String, limit: String): Observable<Response<NewsResponse>> {
        return newsApi.getRedditNews(before, after, limit)
    }
}

@GetNewsScope
class NewsService @Inject constructor(private val api: NewsAPI) {
    inline fun Observable<Response<NewsResponse>>.transformToModel(): Observable<List<RedditNewsItem>> {
        return this
                .map { res ->
                    res.body().data.children.map { item ->
                        RedditNewsItem(item.data)
                    }
                }
    }

    fun getNews(before: String? = "", after: String? = "", limit: String? = "10"): Observable<List<RedditNewsItem>> {
        return api.getNews(before!!, after!!, limit!!)
                .onDefaultThread()
//               assert response code successful
                .map {
                    res ->
                    if (!res.isSuccessful)
                        throw RuntimeException("뉴스 정보를 얻어오는데 실패하였습니다. [code : ${res.code()}, reason : ${res.message()}]")
                    res
                }
//              tranform(aggregate) news item
                .transformToModel()

    }
}