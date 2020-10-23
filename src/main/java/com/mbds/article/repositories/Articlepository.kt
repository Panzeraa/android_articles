package com.mbds.article.repositories

import com.mbds.article.model.Article
import com.mbds.article.model.ArticleInfo
import com.mbds.article.services.ArticleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import java.net.URL

class Articlepository {
    private val service: ArticleService
    init {
        val baseUrl = "https://newsapi.org/"
        val url = "https://newsapi.org/v2/everything?q=bitcoin&apiKey=79e9f5affe334dadbf8b3e91d382bcb7/"
        val retrofit = Retrofit.Builder().apply {
            baseUrl(URL(baseUrl))
        }.addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): List<Article>? {
        val response = service.list().execute()
//        println(response.body()?.articles)
        return response.body()?.articles

    }

}