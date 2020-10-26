package com.mbds.article.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.children
import androidx.fragment.app.Fragment
import com.mbds.article.MainActivity
import com.mbds.article.changeFragment
import com.mbds.article.databinding.CategorieChoiceBinding
import java.lang.reflect.Array.newInstance

/**
 * A simple [Fragment] subclass.
 * Use the [ChoiceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChoiceFragment : Fragment() {

    lateinit var binding: CategorieChoiceBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = CategorieChoiceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.children.filter {
            it is Button
        }.forEach {
            it.setOnClickListener { view ->
                (activity as? MainActivity)?.changeFragment(
                    ArticlesFragment.newInstance(
                        view.tag?.toString() ?: "politique"
                    )
                )
            }
        }
    }

    companion object {
        fun newInstance(): ChoiceFragment {
            return ChoiceFragment()
        }
    }
}