package com.example.hash.myself.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.hash.R
import com.example.hash.base.BaseActivity
import com.example.hash.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : BaseActivity() {

    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //登录
        binding.signInButton.setOnClickListener {
            val username = binding.inUsernameEdit.text.toString()
            val password = binding.inPasswordEdit.text.toString()

            if (password.isBlank() || username.isBlank()) {
                Toast.makeText(this, "用户名、密码均不能为空", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //firebase
            val auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(username, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
                    goMainActivity()
                } else {
                    Log.e("SignInActivity", "登陆失败",it.exception)
                    Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun goMainActivity() {
        Log.i("SignInActivity", "登录成功")
    }
}
