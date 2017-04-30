package com.hucet.newskotlin.module.data.component

import com.hucet.newskotlin.module.data.component.scope.NewsScope
import com.hucet.todo.NewsFragment
import dagger.Subcomponent

@NewsScope
@Subcomponent(modules = arrayOf(NewsModule::class))
interface NewsComponent {
    fun inject(newsFragment: NewsFragment)
}