package com.example.hash.message

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hash.R
import com.example.hash.databinding.FragmentHomeBinding
import com.example.hash.databinding.FragmentMessageBinding
import com.example.hash.message.adapter.ViewPagerAdapter

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMessageBinding.inflate(inflater, container, false)

        val list = mutableListOf<Int>(
            R.drawable.bottom_home,
            R.drawable.bottom_message,
            R.drawable.bottom_myself,
            R.drawable.bottom_home
        )
        binding.messageViewPager.adapter = ViewPagerAdapter(list)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}