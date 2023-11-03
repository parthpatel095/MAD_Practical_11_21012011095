package com.example.mad_practical_11_21012011095

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.button.MaterialButton

class PersonAdapter
    (val context: Context,val personarray:ArrayList<Person>):RecyclerView.Adapter<PersonAdapter.PersonViewHolder>()
{
    inner class PersonViewHolder(val view: View):RecyclerView.ViewHolder(view)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.person_item,parent,false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personarray.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val view=holder.view
        view.findViewById<TextView>(R.id.tv_layout_1).text = personarray[position].name
        view.findViewById<TextView>(R.id.tv_layout_2).text = personarray[position].phoneNo
        view.findViewById<TextView>(R.id.tv_layout_3).text = personarray[position].Email
        view.findViewById<TextView>(R.id.tv_layout_4).text = personarray[position].address
        view.findViewById<MaterialButton>(R.id.MatrialButoon1).setOnClickListener {
            Intent(context, MapsActivity::class.java).putExtra("object",personarray[position]).apply { context.startActivity(this) }
        }
    }
}