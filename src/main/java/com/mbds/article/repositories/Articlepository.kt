package com.mbds.article.repositories

import android.content.Context
import android.view.View
import android.widget.Toast
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
//        val url = "https://newsapi.org/v2/everything?q=bitcoin&apiKey=79e9f5affe334dadbf8b3e91d382bcb7/"
        val retrofit = Retrofit.Builder().apply {
            baseUrl(URL(baseUrl))
        }.addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(categorie: String): List<Article>? {
        val response = service.list(categorie).execute()
        println(response.code())
//        when(response.code()){
//            400-> Toast.makeText(context, "Bad Request. The request was unacceptable, often due to a missing or misconfigured parameter.", Toast.LENGTH_SHORT).show()
//            401-> Toast.makeText(context, "Unauthorized. Your API key was missing from the request, or wasn't correct.", Toast.LENGTH_SHORT).show()
//            429-> Toast.makeText(context, "Too Many Requests. You made too many requests within a window of time and have been rate limited. Back off for a while.", Toast.LENGTH_SHORT).show()
//            500-> Toast.makeText(context, "Server Error. Something went wrong on our side.", Toast.LENGTH_SHORT).show()
//            else-> Toast.makeText(context, "OK. The request was executed successfully.", Toast.LENGTH_SHORT).show()
//        }
        return response.body()?.articles

    }

}