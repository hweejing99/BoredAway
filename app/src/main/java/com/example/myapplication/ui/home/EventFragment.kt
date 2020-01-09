package com.example.myapplication.ui.home

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class EventFragment : Fragment() {

    private lateinit var eventViewModel: EventViewModel
    private lateinit var eventView: View
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mFirebaseDatabase: FirebaseDatabase
    private lateinit var mReference: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //ActionBar
        //var actionBar: ActionBar?.getSupportActionBar()
        //actionBar?.title = "Post Lists"

         // Inflate the layout for this fragment
         eventView = inflater.inflate(R.layout.fragment_home, container, false)

         //RecyclerView
         mRecyclerView = eventView.findViewById(R.id.recyclerViewFeeds)
         mRecyclerView.setHasFixedSize(true)

         //set layout as Linear Layout
         mRecyclerView.layoutManager = LinearLayoutManager(context)

        //send Query to FirebaseDatabase
        mFirebaseDatabase = FirebaseDatabase.getInstance()
        mReference = mFirebaseDatabase.reference.child("Data")

        return eventView
    }

    //load data into recycler view onStart
    override fun onStart() {
        super.onStart()

        var options = FirebaseRecyclerOptions.Builder<Event>().setQuery(mReference, Event::class.java).build()
        var firebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<Event, EventViewHolder>(options){
            override fun onBindViewHolder(holder: EventViewHolder, position: Int, event: Event) {
                holder.setDetails(context, event.title, event.desc, event.image)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
                val inflater: LayoutInflater = LayoutInflater.from(parent.context)
                val itemView = inflater.inflate(R.layout.feed_row, parent, false)
                return EventViewHolder(itemView)
            }
        }
        //set adapter to recycler view
        mRecyclerView.adapter = firebaseRecyclerAdapter
        firebaseRecyclerAdapter.startListening()
    }
}