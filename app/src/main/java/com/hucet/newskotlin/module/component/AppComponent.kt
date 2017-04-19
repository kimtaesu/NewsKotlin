package com.hucet.newskotlin.module.component

import com.hucet.newskotlin.module.AppModule
import com.hucet.newskotlin.module.service.RetrofitModule
import dagger.Component

@Component(modules = arrayOf(AppModule::class, RetrofitModule::class))
class AppComponent {

}