package com.mbds.article.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment


//class InformationsFragment : Fragment(), TextWatcher {
////
////    private lateinit var binding: InformationsFragment
////    private lateinit var operation: String
////
////    override fun onCreateView(
////        inflater: LayoutInflater,
////        container: ViewGroup?,
////        savedInstanceState: Bundle?
////    ): View? {
////        binding = InformationsFragment.inflate(inflater, container, false)
////        return binding.root
////    }
////
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////
////    }
////
////
////    private fun EditText.getNumber() = text.toString().toDouble()
////
////    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
////        //
////    }
////
////    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
////
////    }
////
////    override fun afterTextChanged(s: Editable?) {
////
////    }
////
////    private fun EditText.isNotNullOrBlank() = text != null && text.isNotBlank()
////
////
////
////    companion object {
////        fun newInstance(operation: String): ComputationFragment {
////            return ComputationFragment().apply {
////                this.operation = operation
////            }
////        }
////    }
//
//}
