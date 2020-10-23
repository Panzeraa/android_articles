package com.mbds.article.model

import java.util.*

data class Article(val source: Object,
                   val author: String,
                   val title: String,
                   val description: String,
                   val url: String,
                   val urlToImage: String,
                   val publishedAt: Date,
                   val content: String
                   )

