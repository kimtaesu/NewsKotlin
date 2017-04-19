package com.hucet.newskotlin.api.response

class NewsResponse(val data: DataResponse)

class DataResponse(
        val children: List<ChildrenResponse>,
        val after: String?,
        val before: String?
)

class ChildrenResponse(val data: NewsDataResponse)

class NewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String?
)