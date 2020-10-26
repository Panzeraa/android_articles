package com.mbds.article.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mbds.article.MainActivity
import com.mbds.article.R
import com.mbds.article.adapters.CategoriAdapter
import com.mbds.article.changeFragment
import com.mbds.article.databinding.CategorieChoiceBinding
import com.mbds.article.databinding.FragmentCategoriesBinding
import com.mbds.article.model.Category

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {

    lateinit var binding: FragmentCategoriesBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles = listOf(
                Category(name = "politique", description = "Voir les articles liés à la catégorie politique", image = "https://picsum.photos/500/300"),
                Category(name = "économie", description = "Voir les articles liés à la catégorie économie", image = "https://picsum.photos/500/300"),
                Category(name = "éducation", description = "Voir les articles liés à la catégorie politique", image = "https://picsum.photos/500/300"),
                Category(name = "pandémie", description = "Voir les articles liés à la catégorie pandémie", image = "https://picsum.photos/500/300"),
                Category(name = "scientifique", description = "Voir les articles liés à la catégorie scientifique", image = "https://picsum.photos/500/300"),
                Category(name = "biologie", description = "Voir les articles liés à la catégorie biologie", image = "https://picsum.photos/500/300"),
                Category(name = "error", description = "Catégorie error pour tester une erreur 404", image = "https://picsum.photos/500/300")
        )
        val adapterRecycler = CategoriAdapter(articles)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.adapter = adapterRecycler

        binding.root.children.filter {
            true
        }.forEach {
            println("HELLO")

            it.setOnClickListener { view ->
                print(view.findViewById<TextView>(R.id.category_name).text)
                (activity as? MainActivity)?.changeFragment(
                        ArticlesFragment.newInstance(
                                view.findViewById<TextView>(R.id.category_name).text?.toString() ?: "politique"
                        )
                )
            }
        }
    }

}