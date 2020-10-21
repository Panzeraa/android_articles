package com.mbds.article.repositories

import com.mbds.article.model.Article
import com.mbds.article.services.ArticleService
import retrofit2.Retrofit

class Articlepository {
    private val service: ArticleService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("[URL]")
        }.build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): List<Article> {
        val response = service.list().execute()
        return response.body() ?: emptyList()
    }
}