package com.hucet.newskotlin.module.component

import com.hucet.newskotlin.module.AppModule
import com.hucet.newskotlin.module.NewsModule
import com.hucet.newskotlin.module.NetworkModule
import com.hucet.todo.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class, NetworkModule::class))
interface AppComponent {
    fun plus(newsModule: NewsModule): NewsComponent
}