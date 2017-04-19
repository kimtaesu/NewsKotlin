package com.hucet.newskotlin.api

import com.hucet.newskotlin.api.repository.NewsService
import com.hucet.newskotlin.api.request.NewsRequest
import com.hucet.newskotlin.api.response.NewsResponse
import com.hucet.newskotlin.module.scope.NewsScope
import com.hucet.todo.extension.onDefaultThread
import com.hucet.todo.model.RedditNewsItem
import io.reactivex.Observable
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@NewsScope
class NewsManager @Inject constructor(val request: NewsRequest, val newsService: NewsService) {
    fun getNews(): Observable<List<RedditNewsItem>> {
        return newsService.getRedditNews(request.before!!, request.after!!, request.limit!!)
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

    private inline fun Observable<Response<NewsResponse>>.transformToModel(): Observable<List<RedditNewsItem>> {
        return this
                .map { res ->
                    res.body().data.children.map { item ->
                        RedditNewsItem(item.data)
                    }
                }
    }


}