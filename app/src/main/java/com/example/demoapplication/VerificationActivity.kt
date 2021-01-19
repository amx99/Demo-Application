package com.example.demoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat

class VerificationActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val verify: TextView = findViewById(R.id.verify_text)
        val verifyBtn: TextView = findViewById(R.id.verify)

        val text = "<font color='white'>We have sent you OTP on your mobile number " +
                "</font><font color='#2e2f41'><b>+91 98* *** **21.</b></font>";
        verify.setText(HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY))

        verifyBtn.setOnClickListener() {
            val intent = Intent(this, TermsOfUseActivity::class.java)
            startActivity(intent)
        }

    }
}