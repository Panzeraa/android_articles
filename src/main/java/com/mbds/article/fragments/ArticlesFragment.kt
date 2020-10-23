package com.mbds.article.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.article.R
import com.mbds.article.adapters.ArticleAdapter

import com.mbds.article.model.Article
import com.mbds.article.model.ArticleInfo
import com.mbds.article.repositories.Articlepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArticlesFragment : Fragment() {
    private val repository = Articlepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles = mutableListOf<Article>()
        //articles.add("","","","","","","","")
        val adapterRecycler = ArticleAdapter(articles)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler
    }



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycleScope.launch {
            getData()
        }
    }
    //S'execute dans un thread secondaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            if (result != null) {
                bindData(result.articles)
            }
        }
    }
    //S'execute sur le thread principal
//    private suspend fun bindData(result: List<Article>) {
//        withContext(Dispatchers.Main) {
////afficher les données dans le recycler
//        }
//    }
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
//afficher les données dans le recycler
        }
    }

}

private fun Lifecycle.launch(function: () -> Unit) {

}
