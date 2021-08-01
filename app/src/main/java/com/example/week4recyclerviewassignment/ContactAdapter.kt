package com.example.week4recyclerviewassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val item:List<Items>, private val onContactClickListener: OnContactClickListener):RecyclerView.Adapter<ContactAdapter.ViewItemHolder>(){

    inner class ViewItemHolder(viewItems: View):RecyclerView.ViewHolder(viewItems){
        val images = viewItems.findViewById<ImageView>(R.id.img)
        val texts = viewItems.findViewById<TextView>(R.id.names)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_design,parent,false)
        return ViewItemHolder(view)
    }

    override fun onBindViewHolder(holder: ViewItemHolder, position: Int) {
       val itemPosition = item[position]
        holder.images.setImageResource(itemPosition.photos)
        holder.texts.text = itemPosition.people

        holder.itemView.setOnClickListener{
            onContactClickListener.OnContactItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
       return item.size
    }
}