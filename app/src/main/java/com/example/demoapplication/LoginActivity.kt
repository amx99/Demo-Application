package com.example.demoapplication

import android.content.Intent
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.demoapplication.Home.HomeActivity

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signUp: TextView = findViewById(R.id.signup)
        val forgotPassword: TextView = findViewById(R.id.forgotPassword)
        val loginBtn: TextView = findViewById(R.id.loginHome)

        val signUpLabel =SpannableStringBuilder("Don't have an account? Sign Up").also {
            it.setSpan(
                ForegroundColorSpan(
                    ContextCompat.getColor(
                        this,
                        R.color.colorGreen
                    )
                ),23,30,0
            )
        }

        signUp.text = signUpLabel

        signUp.setOnClickListener() {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        forgotPassword.setOnClickListener() {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener() {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}