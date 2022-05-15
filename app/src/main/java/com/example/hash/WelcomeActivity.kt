package com.example.hash

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.hash.base.BaseActivity
import android.app.Activity




class WelcomeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setTranslucent(this)
        Thread {
            try {
                Thread.sleep(1000)
                startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
                finish()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }.start()
    }

    fun setTranslucent(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
    }
}