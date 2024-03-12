package com.example.foodrunner

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class HomePageActivity : AppCompatActivity() {


    lateinit var txtYourName3: TextView
    lateinit var txtEmailAddress3: TextView
    lateinit var txtMobileNumber3: TextView
    lateinit var txtDeliveryAddress3: TextView
    lateinit var txtPassword3: TextView

    lateinit var btnLogOut3: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        title = "Customer Details"

        txtYourName3 = findViewById(R.id.txtYourName3)
        txtEmailAddress3 = findViewById(R.id.txtEmailAddress3)
        txtMobileNumber3 = findViewById(R.id.txtMobileNumber3)
        txtDeliveryAddress3 = findViewById(R.id.txtDeliveryAddress3)
        txtPassword3 = findViewById(R.id.txtPassword3)

        val sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

        txtYourName3.text = "Name: ${sharedPreferences.getString("Name", "")}"
        txtEmailAddress3.text = "Email : ${sharedPreferences.getString("Email", "")}"
        txtMobileNumber3.text = "Ph.no. : ${sharedPreferences.getString("MobileNumber", "")}"
        txtDeliveryAddress3.text = "Address : ${sharedPreferences.getString("DeliveryAddress", "")}"
        txtPassword3.text = "Password : ${sharedPreferences.getString("Password", "")}"
        btnLogOut3 = findViewById(R.id.btnLogOut3)

        btnLogOut3.setOnClickListener {
            sharedPreferences.edit().putBoolean("Login",false).apply()
            startActivity(Intent(this@HomePageActivity, LoginActivity::class.java))
        }


    }
    override fun onPause(){
        super.onPause()
        finish()
    }
}