package com.example.listviewkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.listviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryArrayList: ArrayList<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name= arrayOf(
            "Argentina", "Chile", "Paraguay", "Bolivia", "Peru", "Ecuador", "Brasil", "Colombia", "Uruguay"
        )

        val population= arrayOf(
            "15.000.000", "10.000.000", "13.500.000", "8.760.500", "28.960.560", "9.899.900", "69.899.900", "48.006.876", "5..423.665"
        )

        countryArrayList = ArrayList()

        for( i in name.indices){
            val country_item = Country(name[i], population[i])
            countryArrayList.add(country_item)
        }
        binding.listView.isClickable= true
        binding.listView.adapter = MyAdapter(this, countryArrayList)
        val adapter = MyAdapter(this, countryArrayList)
        binding.listView.adapter= adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val name_country = name[position] as String
            val pop_country = population[position] as String
            Toast.makeText(this, "la poblacion en $name_country es : $pop_country habitantes.", Toast.LENGTH_SHORT).show()
        }

    }
}