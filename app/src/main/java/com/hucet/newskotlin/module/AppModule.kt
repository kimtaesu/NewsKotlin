package com.hucet.newskotlin.module.data.component

import android.app.Application
import dagger.Module
import javax.inject.Singleton


@Singleton
@Module
class AppModule(val application: Application) {

}
