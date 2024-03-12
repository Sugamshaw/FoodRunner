package com.example.foodrunner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ForgetPassword : AppCompatActivity() {

    lateinit var edMobileNumber2: EditText
    lateinit var edEmailAddress2: EditText
    lateinit var btnNext2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)

        title = "Forget Password"
        edMobileNumber2 = findViewById(R.id.edMobileNumber2)
        edEmailAddress2 = findViewById(R.id.edEmailAddress2)
        btnNext2 = findViewById(R.id.btnNext2)


        btnNext2.setOnClickListener {

            val sharedPreferences =
                getSharedPreferences(getString(R.string.preference_file), Context.MODE_PRIVATE)

            val inputedMobile = edMobileNumber2.text.toString()
            val inputedEmailid = edEmailAddress2.text.toString()
            val storedMobile = sharedPreferences.getString("MobileNumber", "")
            val storedEmailid = sharedPreferences.getString("Email", "")

            if (inputedMobile != "" && inputedEmailid != "") {
                if (inputedMobile == storedMobile && inputedEmailid == storedEmailid) {
                    sharedPreferences.edit().putBoolean("Login", true).apply()
                    startActivity(Intent(this@ForgetPassword, HomePageActivity::class.java))
                } else {
                    Toast.makeText(this, "Incorrect Mobile number or Email", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onPause(){
        super.onPause()
        finish()
    }
}