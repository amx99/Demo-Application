package com.example.demoapplication.Home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R

class HomeActivity: AppCompatActivity() {

    private var gridLayoutManager: GridLayoutManager? = null
    private var adapter: HomeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        gridLayoutManager = GridLayoutManager(this,2)

        val rvHome = findViewById<RecyclerView>(R.id.rvHome)

        rvHome.layoutManager = gridLayoutManager

        adapter = HomeAdapter(ContextCompat.getColor(this, R.color.colorGreen))
        rvHome.adapter = adapter

        rvHome.addItemDecoration(
            HomeSpacing(resources.getDimensionPixelSize(R.dimen.item_name))
        )
    }
}