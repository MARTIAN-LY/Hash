package com.example.hash.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hash.databinding.FragmentFunnyBinding
import com.example.hash.home.adapter.BlogRecyclerAdapter
import com.example.hash.home.models.DataSource4
import com.example.hash.home.models.TopSpacingItemDecoration



class FunnyFragment : Fragment() {

    // This property is only valid between onCreateView and onDestroyView.
    private var _binding: FragmentFunnyBinding? = null
    private val binding get() = _binding!!
    private lateinit var blogAdapter: BlogRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFunnyBinding.inflate(inflater, container, false)
        initRecycler()
        return binding.root
    }

    private fun initRecycler(){
        val topPadding = TopSpacingItemDecoration(30)
        binding.funnyRecycler.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(topPadding)
            blogAdapter = BlogRecyclerAdapter(DataSource4.createDataSet())
            adapter = blogAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}