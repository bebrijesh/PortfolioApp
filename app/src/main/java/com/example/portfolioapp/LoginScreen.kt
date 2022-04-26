package com.example.portfolioapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton = findViewById(R.id.button_login) as Button
        loginButton.setOnClickListener {
            val intent = Intent(this, ProfileScreen::class.java)
            startActivity(intent)

            Toast.makeText(applicationContext, "Login Successfully!", Toast.LENGTH_LONG).show()

            val signupButton = findViewById(R.id.button_signup) as Button
            signupButton.setOnClickListener {
                val intent = Intent(this, SignupScreen::class.java)
                startActivity(intent)
            }
        }
    }
}