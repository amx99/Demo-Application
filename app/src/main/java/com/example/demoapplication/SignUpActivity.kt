package com.example.demoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class SignUpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val login: TextView = findViewById(R.id.login)
        val checkBox: CheckBox = findViewById(R.id.check_box)
        val signup: TextView = findViewById(R.id.sign_up)

        val text = "<font color='white'>Do you have an account?</font>" +
                "<font color='#cb0e36'> Login</font>";
        login.setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))

        val text2 = "<font color='white'>By creating your accont you confirm that You’ve read " +
                "and accept the</font><font color='#cb0e36'> Terms Of Use</font>";
        checkBox.setText(HtmlCompat.fromHtml(text2, HtmlCompat.FROM_HTML_MODE_LEGACY))

        login.setOnClickListener(){
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener(){
            val intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }

    }
}