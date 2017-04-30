package com.hucet.newskotlin.module

import android.app.Application
import dagger.Module
import javax.inject.Singleton


@Singleton
@Module
class AppModule(val application: Application) {

}
