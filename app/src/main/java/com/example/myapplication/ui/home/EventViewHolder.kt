package com.example.myapplication.ui.home

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.squareup.picasso.Picasso

class EventViewHolder(var mView: View) : RecyclerView.ViewHolder(mView) {
    fun setDetails(
        ctx: Context?,
        title: String?,
        desc: String?,
        image: String?
    ) {
        //Views
        val tvTitleInput = mView.findViewById<TextView>(R.id.tvTitle)
        val tvDetailInput = mView.findViewById<TextView>(R.id.tvDesc)
        val ivImageInput =  mView.findViewById<ImageView>(R.id.ivImage)
        //set data to views
        tvTitleInput.text = title
        tvDetailInput.text = desc
        Picasso.get().load(image).into(ivImageInput)
    }
}