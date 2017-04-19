package com.hucet.newskotlin.api.request

data class NewsRequest(val before: String? = "", val after: String? = "", val limit: String? = "10");
