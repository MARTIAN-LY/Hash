package com.example.hash.myself.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hash.R
import com.example.hash.databinding.ActivitySignInBinding
import com.example.hash.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener {
            val username = binding.upUsernameEdit.text.toString()
            val password = binding.upPasswordEdit.text.toString()

            if (password.isBlank() || username.isBlank()){
                Toast.makeText(this, "用户名、密码均不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //firebase
            val auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(username,password)
        }
    }
}