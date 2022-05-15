package com.example.hash.home.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hash.home.fragment.*

class FragmentAdapter(val fragmentManager: FragmentManager, val lifeCycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifeCycle) {


    override fun getItemCount() = 7

    override fun createFragment(position: Int): Fragment = when (position) {
        1 -> GameFragment()
        2 -> GenshinFragment()
        3 -> ComplainFragment()
        4 -> FunnyFragment()
        5 -> SportsFragment()
        6 -> EventsFragment()
        else -> StudyFragment()
    }
}