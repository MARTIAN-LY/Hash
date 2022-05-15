package com.example.hash

import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import com.example.hash.base.BaseActivity
import com.example.hash.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //切换界面
        val navController = findNavController(this, R.id.host_fragment)
        binding.bottomNavigationView.setupWithNavController( navController)

        //设置红点
        binding.bottomNavigationView.getOrCreateBadge(R.id.messageFragment)


    }
}