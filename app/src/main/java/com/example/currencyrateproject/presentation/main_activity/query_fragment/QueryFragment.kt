package com.example.currencyrateproject.presentation.main_activity.query_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.currencyrateproject.R
import com.example.currencyrateproject.databinding.FragmentQueryBinding

class QueryFragment : Fragment() {

    private lateinit var binding: FragmentQueryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_query, container, false)
        binding = FragmentQueryBinding.bind(view)

        binding.findButton.setOnClickListener {
            Toast.makeText(this.context, "Test Button", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}