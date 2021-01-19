package com.example.demoapplication.ServiceProvider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplication.R

class ServiceProviderAdapter(var c: Context, var users: Array<ServiceProviderActivity.Users>): RecyclerView.Adapter<ServiceProviderAdapter.MyHolder>() {

    var checkedUsers = ArrayList<ServiceProviderActivity.Users>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ServiceProviderAdapter.MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_service_provider, null)
        return MyHolder(v)
    }

    override fun onBindViewHolder(holder: ServiceProviderAdapter.MyHolder, position: Int) {
        val user = users[position]
        holder.itemName.text = user.name
        holder.itemLocation.text = user.location
        holder.spCheckBox.isChecked = user.isSelected
        holder.itemImage.setImageResource(user.image)

        holder.setItemClickListener(object: ItemClickListener{
            override fun onItemClick(v: View, pos: Int) {
                val currentUser = users[pos]

                currentUser.isSelected = !currentUser.isSelected
                notifyItemChanged(pos)
            }
        })
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var itemName: TextView
        var itemImage: ImageView
        var itemLocation: TextView
        var spCheckBox: CheckBox

        lateinit var myItemClickListener: ItemClickListener

        init {
            itemName = itemView.findViewById(R.id.userName)
            itemImage = itemView.findViewById(R.id.userImage)
            itemLocation = itemView.findViewById(R.id.userLocation)
            spCheckBox = itemView.findViewById(R.id.spCheckBox)

            spCheckBox.setOnClickListener(this)
        }

        fun setItemClickListener(ic: ItemClickListener) {
            this.myItemClickListener = ic
        }

        override fun onClick(v: View) {
            this.myItemClickListener.onItemClick(v, layoutPosition)
        }
    }

    fun getItemSelected(): ArrayList<ServiceProviderActivity.Users> {
        val selectedItems = ArrayList<ServiceProviderActivity.Users>()
        for (item in users) {
            if (item.isSelected) {
                selectedItems.add(item)
            }
        }
        return selectedItems
    }

    interface ItemClickListener {
        fun onItemClick(v: View, pos: Int)
    }
}