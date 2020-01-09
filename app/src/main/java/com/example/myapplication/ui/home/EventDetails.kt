package com.example.myapplication.ui.home

import android.content.Context
import android.icu.text.CaseMap
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.feed_details.*
import kotlinx.android.synthetic.main.feed_row.*

class EventDetails : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feed_details)

        val bundle: Bundle? = intent.extras
        val Image = bundle!!.getString("Firebase_image")
        val Title = bundle.getString("Firebase_title")
        val DateTime = bundle.getString("Firebase_dt")
        val Desc = bundle.getString("Firebase_desc")
        val Venue = bundle.getString("Firebase_venue")

        txtTitle.setText(Title)
        textDesc.setText(Desc)
        txtVenue.setText(Venue)
        txtDT.setText(DateTime)
        Picasso.get().load(Image).into(detailsImageView)







    }
}