package com.example.hash.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.hash.databinding.FragmentHomeBinding
import com.example.hash.home.activities.SearchActivity
import com.example.hash.home.adapter.FragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener


class HomeFragment : Fragment() {

    // This property is only valid between onCreateView and onDestroyView.
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var fragmentAdapter : FragmentAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //顶部搜索栏点击事件
        binding.homeTopText.setOnClickListener {
            startActivity(Intent(activity, SearchActivity::class.java))
        }

        /**  实验   */
        binding.viewPager.adapter = FragmentAdapter(parentFragmentManager,lifecycle)

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("学习"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("游戏"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("原神"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("吐槽"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("趣事"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("运动"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("活动"))


        binding.tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                binding.viewPager.setCurrentItem(tab.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })

        /** AHAHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA,NICEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE*/


        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}