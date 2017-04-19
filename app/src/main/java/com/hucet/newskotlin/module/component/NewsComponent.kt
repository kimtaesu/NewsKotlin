package com.hucet.newskotlin.module.component

import com.hucet.newskotlin.module.NetworkModule
import com.hucet.newskotlin.module.NewsModule
import com.hucet.newskotlin.module.scope.NewsScope
import com.hucet.todo.NewsFragment
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@NewsScope
@Subcomponent(modules = arrayOf(NewsModule::class))
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)

}