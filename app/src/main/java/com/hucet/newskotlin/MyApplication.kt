package com.hucet.newskotlin

import android.app.Application
import com.hucet.newskotlin.api.request.NewsRequest
import com.hucet.newskotlin.module.AppModule
import com.hucet.newskotlin.module.NetworkModule
import com.hucet.newskotlin.module.NewsModule
import com.hucet.newskotlin.module.component.AppComponent
import com.hucet.newskotlin.module.component.DaggerAppComponent
import com.hucet.newskotlin.module.component.NewsComponent
import timber.log.Timber

class MyApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
        lateinit var newsComponent: NewsComponent

        fun getNewsComponent(request: NewsRequest): NewsComponent {
            newsComponent = appComponent.plus(NewsModule(NewsRequest()))
            return newsComponent
        }

    }


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return "${super.createStackElementTag(element)} [Thread:${Thread.currentThread()}]"
                }
            })
        }
        appComponent = DaggerAppComponent.builder()
                .networkModule(NetworkModule())
                .appModule(AppModule(this))
                .build()

    }

}