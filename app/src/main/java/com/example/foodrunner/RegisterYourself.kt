package com.example.foodrunner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class RegisterYourself : AppCompatActivity() {

    lateinit var edEnterYourName1: EditText
    lateinit var edEmailAddress1: EditText
    lateinit var edMobileNumber1: EditText
    lateinit var edDeliveryAddress1: EditText
    lateinit var edPassword1: EditText
    lateinit var edConfirmPassword1: EditText

    lateinit var btnRegister1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_yourself)

        //imgArrowKey1=findViewById(R.id.imgArrowKey1)

        edEnterYourName1 = findViewById(R.id.edEnterYourName1)
        edEmailAddress1 = findViewById(R.id.edEmailAddress1)
        edMobileNumber1 = findViewById(R.id.edMobileNumber1)
        edDeliveryAddress1 = findViewById(R.id.edDeliveryAddress1)
        edPassword1 = findViewById(R.id.edPassword1)
        edConfirmPassword1 = findViewById(R.id.edConfirmPassword1)

        btnRegister1 = findViewById(R.id.btnRegister1)

        title = "Register Yourself"

        btnRegister1.setOnClickListener {

            val intName = edEnterYourName1.text.toString()
            val intEmail = edEmailAddress1.text.toString()
            val intMobileNumber = edMobileNumber1.text.toString()
            val intDeliveryAddress = edDeliveryAddress1.text.toString()
            val intPassword = edPassword1.text.toString()
            val intConfirmPassword = edConfirmPassword1.text.toString()
            val sharedPreferences =
                getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

            if (intName != "" && intEmail != "" && intMobileNumber != "" && intDeliveryAddress != "" && intPassword != "" && intConfirmPassword != "") {
                if (intName.length >= 3) {
                    if (intMobileNumber.length == 10) {
                        if (intPassword.length >= 4) {
                            if (intPassword == intConfirmPassword) {
                                sharedPreferences.edit().clear().apply()
                                sharedPreferences.edit().putString("Name", intName).apply()
                                sharedPreferences.edit().putString("Email", intEmail).apply()
                                sharedPreferences.edit()
                                    .putString("MobileNumber", intMobileNumber).apply()
                                sharedPreferences.edit()
                                    .putString("DeliveryAddress", intDeliveryAddress).apply()
                                sharedPreferences.edit().putString("Password", intPassword)
                                    .apply()
                                sharedPreferences.edit().putBoolean("Login", true).apply()
                                println("hi buddy")
                                startActivity(
                                    Intent(
                                        this@RegisterYourself,
                                        HomePageActivity::class.java
                                    )
                                )

                            } else {
                                Toast.makeText(
                                    this,
                                    "Please check Confirm Password",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        } else {
                            Toast.makeText(this, "Minimum 4 Digit Password", Toast.LENGTH_LONG)
                                .show()
                        }
                    } else {
                        Toast.makeText(this, "Invalid Mobile Number", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Atleast 3 characters for name", Toast.LENGTH_LONG).show()
                }

            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }

        }
    }
    override fun onPause(){
        super.onPause()
        finish()
    }
}