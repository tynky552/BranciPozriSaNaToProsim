package com.example.recycleviewproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_items.view.*

class PersonAdapter(private val list: ArrayList<Person>, private val onPersonClickListener: OnPersonClickListener) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v : View = LayoutInflater.from(parent.context).inflate(R.layout.list_items , parent , false)
        return ViewHolder(v, onPersonClickListener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    class ViewHolder(itemView: View, private val onPersonClickListener: OnPersonClickListener) : RecyclerView.ViewHolder(itemView) {

        fun bindData(person: Person) {
            itemView.tvName.text = person.name
            itemView.tvSurname.text = person.surname
            if (person.preference.equals("bus"))itemView.ivPreference.setImageResource(R.drawable.plane)
            else itemView.ivPreference.setImageResource(R.drawable.bus)

            itemView.setOnClickListener {
                onPersonClickListener.onPersonClicked(person.surname)
            }
        }
    }

    interface OnPersonClickListener {
        fun onPersonClicked(name: String?)
    }
}