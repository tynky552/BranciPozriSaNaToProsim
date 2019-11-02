package com.example.recycleviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), PersonAdapter.OnPersonClickListener {

    override fun onPersonClicked(name: String?) {
        name?.let {
            Toast.makeText(this, it, Toast.LENGTH_SHORT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<Person>()
        list.add(Person("Ja", "Bily", "bus"))
        list.add(Person("Ja", "Bilysdsadad", "plane"))
        list.add(Person("Ja", "Bilye", "plane"))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PersonAdapter(list, this)

        btnAdd.setOnClickListener(View.OnClickListener {
            list.add(Person("${tvAddName.text}", "${tvAddSurname.text}" , "${tvPreference.text}"))
        })
    }
}


