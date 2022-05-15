package com.example.hash.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hash.databinding.FragmentStudyBinding
import com.example.hash.home.adapter.BlogRecyclerAdapter
import com.example.hash.home.models.TopSpacingItemDecoration
import drawable.DataSource0

class StudyFragment : Fragment() {

    // This property is only valid between onCreateView and onDestroyView.
    private var _binding: FragmentStudyBinding? = null
    private val binding get() = _binding!!
    private lateinit var blogAdapter: BlogRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStudyBinding.inflate(inflater, container, false)
        initRecycler()
        return binding.root
    }

    private fun initRecycler(){
        val topPadding = TopSpacingItemDecoration(30)
        binding.studyRecycler.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(topPadding)
            blogAdapter = BlogRecyclerAdapter(DataSource0.createDataSet())
            adapter = blogAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}