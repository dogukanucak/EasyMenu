package com.example.dogukan.easymenu.Adapter

import android.content.Context
import android.graphics.Color
import com.example.dogukan.easymenu.Adapter.MenuAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.dogukan.easymenu.Model.menuItem
import kotlinx.android.synthetic.main.item_cell.view.*



import java.util.ArrayList
/**
 * Created by Dogukan on 14.02.2018.
 */

internal class MenuAdapter(private val arrayList: ArrayList<menuItem>,
                            private val context: Context,
                            private val layout: Int) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(items: menuItem) {
            if(items.available == true)
            {
                itemView.item_cell_layout.setBackgroundColor(Color.GREEN)
            }
            else
            {
                itemView.item_cell_layout.setBackgroundColor(Color.RED)
            }
            itemView.tvName.text = items.menu_name
            itemView.tvNumber.text = items.price.toString()


        }

    }
}