package com.hucet.newskotlin.module.data.component

import com.hucet.newskotlin.module.data.component.AppModule
import com.hucet.newskotlin.module.data.component.NewsModule
import com.hucet.newskotlin.module.data.component.NetworkModule
import com.hucet.todo.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class, NetworkModule::class))
interface AppComponent {
    fun plus(newsModule: NewsModule): NewsComponent
}