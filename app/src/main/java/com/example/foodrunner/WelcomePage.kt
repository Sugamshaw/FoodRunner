package com.example.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION")
class WelcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)

        Handler().postDelayed({
            val intent= Intent(this@WelcomePage,LoginActivity::class.java)
            startActivity(intent)
        },2000)
    }

    override fun onPause(){
        super.onPause()
        finish()
    }
}