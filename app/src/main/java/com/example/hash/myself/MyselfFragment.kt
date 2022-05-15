package com.example.hash.myself

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hash.R
import com.example.hash.databinding.FragmentHomeBinding
import com.example.hash.databinding.FragmentMyselfBinding
import com.example.hash.myself.activities.SignInActivity
import com.example.hash.myself.activities.SignUpActivity


class MyselfFragment : Fragment() {

    // This property is only valid between onCreateView and onDestroyView.
    private var _binding: FragmentMyselfBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyselfBinding.inflate(inflater, container, false)
        binding.signInBtn.setOnClickListener {
            startActivity(Intent(activity,SignInActivity::class.java))
        }
//        binding.signUpBtn.setOnClickListener {
//            startActivity(Intent(activity, SignUpActivity::class.java))
//        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}