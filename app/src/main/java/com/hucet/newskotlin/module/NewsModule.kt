package com.hucet.newskotlin.module

import com.hucet.newskotlin.api.NewsManager
import com.hucet.newskotlin.api.repository.NewsService
import com.hucet.newskotlin.api.request.NewsRequest
import com.hucet.newskotlin.module.scope.NewsScope
import com.hucet.todo.NewsFragment
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Module
class NewsModule(val newsRequest: NewsRequest) {

    @Provides
    @NewsScope
    fun provideNewsRequest(): NewsRequest {
        return newsRequest;
    }

    @Provides
    @NewsScope
    fun provideNewsApiImpl(newsRequest: NewsRequest, newsService: NewsService): NewsManager {
        return NewsManager(newsRequest, newsService)
    }
}


