package com.example.demoapplication.Home

import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R
import com.example.demoapplication.Util.BulletSpan

class HomeAdapter(@ColorInt private val bulletColor: Int): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val item_name = arrayOf("My Task", "ADS Coupon", "Leads", "Messages", "My Customer",
        "Invoice", "Notes", "Settings")
    private val item_image = intArrayOf(R.drawable.group_55541,R.drawable.group_55537,
        R.drawable.group_55539,R.drawable.group_55540,R.drawable.group,R.drawable.group_55428,
        R.drawable.group_55650,R.drawable.frame)
    private val item_new = arrayOf("8 new","","","9 new","","","","")

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView
        var itemImage: ImageView
        var itemNew: TextView

        init {
            itemName = itemView.findViewById(R.id.itemName)
            itemImage = itemView.findViewById(R.id.itemView)
            itemNew = itemView.findViewById(R.id.itemNew)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return item_name.size
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.itemName.text = item_name[position]
        holder.itemImage.setImageResource(item_image[position])
        val new= item_new[position]
        if(item_new[position].isNotBlank()){
            holder.itemNew.text =SpannableStringBuilder(new).also {
                it.setSpan(BulletSpan(15,bulletColor,10),0,1,0)
            }
        }
    }
}