package com.example.demoapplication.ServiceProvider

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R

class ServiceProviderActivity:AppCompatActivity() {

    private val users: Array<Users>
        get() =
            arrayOf(
                Users("Michele Zamparo", "Boston, MA", R.drawable.ellipse),
                Users("Christina Delord","Los Angeles, CA",R.drawable.ellipse1),
                Users("John Atherton","Boston, MA",R.drawable.ellipse2),
                Users("Aseem Riyaz","Los Angeles, CA",R.drawable.ellipse3),
                Users("Andrew Culver","Boston, MA",R.drawable.ellipse4),
                Users("Eduardo Alberto","Los Angeles, CA",R.drawable.ellipse5),
                Users("Michele Zamparo","Boston, MA",R.drawable.ellipse),
                Users("Christina Delord","Los Angeles, CA",R.drawable.ellipse1),
                Users("Jon Atherton","Boston, MA",R.drawable.ellipse2),
                Users("Aseem Riyaz","Los Angeles, CA",R.drawable.ellipse3),
                Users("Andrew Culver","Boston, MA",R.drawable.ellipse4),
                Users("Eduardo Alberto","Los Angeles, CA",R.drawable.ellipse5))
    internal var sb: StringBuilder? = null
    lateinit var serviceProviderAdapter: ServiceProviderAdapter

    inner class Users(var name: String?, val location: String, val image: Int) {
        var isSelected: Boolean = false
    }

    private var linearLayoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider)

        val appointment: Button = findViewById(R.id.appointment)

        linearLayoutManager = LinearLayoutManager(this)
        val rvServiceProvider = findViewById<RecyclerView>(R.id.rvServiceProvider)

        rvServiceProvider.layoutManager = linearLayoutManager

        serviceProviderAdapter = ServiceProviderAdapter(this, users)
        rvServiceProvider.adapter = serviceProviderAdapter

        appointment.setOnClickListener() {
            val items = serviceProviderAdapter.getItemSelected()
            sb = StringBuilder()

            var i=0
            while (i < items.size) {
                val user = items[i]
                sb!!.append(user.name)
                if(i != items.size - 1) {
                    sb!!.append("\n")
                }
                i++
            }

            if (items.size > 0) {
                Toast.makeText(this,sb!!.toString(),Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Please Check an item first", Toast.LENGTH_SHORT).show()
            }
        }
    }
}