package com.mbds.article.services

import com.mbds.article.model.Article
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("/articles")
    fun list(): Call<List<Article>>
}