package com.example.foodrunner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    lateinit var edMobileNumber: EditText
    lateinit var edPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtSignUp: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edMobileNumber = findViewById(R.id.edMobileNumber)
        edPassword = findViewById(R.id.edPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgetPassword = findViewById(R.id.txtForgetPassword)
        txtSignUp = findViewById(R.id.txtSignUp)

        title="Login"

        val sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        val loginCheck = sharedPreferences.getBoolean("Login", false)
        if (loginCheck) {
            val intent = Intent(this@LoginActivity, HomePageActivity::class.java)
            startActivity(intent)
        }


        btnLogin.setOnClickListener {

            val inputedMobile = edMobileNumber.text.toString()
            val inputedPassword = edPassword.text.toString()
            val storedMobile = sharedPreferences.getString("MobileNumber", "")
            val storedPassword = sharedPreferences.getString("Password", "")

            if (inputedMobile!="" && inputedMobile == storedMobile && inputedPassword!="" && inputedPassword == storedPassword) {
                sharedPreferences.edit().putBoolean("Login",true).apply()
                startActivity(Intent(this@LoginActivity, HomePageActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }

        }

        txtForgetPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgetPassword::class.java))
        }

        txtSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterYourself::class.java))
        }

    }

}