package com.example.git_test.model.trainRecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.git_test.R
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private val newsList: ArrayList<News>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.train_list_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titelImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return newsList.size
    }




    class MyViewHolder (itemView : View): RecyclerView.ViewHolder(itemView)
    {
        val titelImage : ImageView = itemView.findViewById(R.id.titel_image)
        val tvHeading : TextView = itemView.findViewById(R.id.tvHeading)
    }
}