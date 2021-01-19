package com.example.demoapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapplication.ServiceProvider.ServiceProviderActivity

class TermsOfUseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_use)

        val acceptBtn: TextView = findViewById(R.id.acceptContinue)

        acceptBtn.setOnClickListener() {
            val intent = Intent(this, ServiceProviderActivity::class.java)
            startActivity(intent)
        }
    }
}