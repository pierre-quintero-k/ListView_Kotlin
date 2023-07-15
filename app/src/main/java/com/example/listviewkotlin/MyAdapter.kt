package com.example.listviewkotlin

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.listviewkotlin.databinding.ListItemBinding

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Country>) : ArrayAdapter<Country>(context,R.layout.list_item,arrayList) {
    private lateinit var binding: ListItemBinding

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListItemBinding = if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            ListItemBinding.inflate(inflater, parent, false)
        } else {
            ListItemBinding.bind(convertView)
        }
        val name_view : TextView= binding.countryView
        name_view.text = arrayList[position].name

        return binding.root
    }
}