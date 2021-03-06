package com.example.dogukan.easymenu

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.text.InputType.TYPE_CLASS_TEXT
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import com.example.dogukan.easymenu.Adapter.MenuAdapter
import com.example.dogukan.easymenu.Callback.AdapterItemListener
import com.example.dogukan.easymenu.Model.menuItem
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList

class MainActivity : AppCompatActivity(), AdapterItemListener {
    private var myAdapter: MenuAdapter? = null
    private var arrayList: ArrayList<menuItem>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        setupList()
        loaddata()
    }

    override fun onClick(pos: Int)
    {
        alert(pos)
    }
    override fun onLongClick(pos: Int)
    {
        Toast.makeText(this, "Long Clicked To Item"+ pos , Toast.LENGTH_SHORT).show()
    }

   private fun alert(pos: Int)
   {
       var m_Text: String? = null
       val builder = AlertDialog.Builder(this)
       builder.setTitle("Title")

       val input = EditText(this)

       input.inputType = TYPE_CLASS_TEXT
       builder.setView(input)


       builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which -> m_Text = input.text.toString() })
       builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
       builder.show()


   }

    private fun loaddata() {

        for (i in 0..9) {
            val myItem = menuItem()

            myItem.menu_name = "Menu -" + i.toString()
            myItem.price = i*10
            myItem.available = i % 2 == 0
            arrayList!!.add(myItem)
        }

        myAdapter!!.notifyDataSetChanged()

    }

    private fun setupList() {
        rlItems!!.layoutManager = layoutManager
        rlItems!!.adapter = myAdapter
    }

    private fun initialize() {
        // rlItems = findViewById(R.id.rlItems) as RecyclerView
        arrayList = ArrayList<menuItem>()
        layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        myAdapter = MenuAdapter(arrayList!!, this,this)

    }
}