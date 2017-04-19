package com.hucet.newskotlin.module.service

import dagger.Module
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class GetNewsScope

@Module
class GetNewsModule {
    @GetNewsScope
    fun getNews() {

    }
}